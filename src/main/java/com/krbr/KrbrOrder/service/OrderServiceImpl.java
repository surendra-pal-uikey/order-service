package com.krbr.KrbrOrder.service;

import com.krbr.KrbrOrder.client.InventoryClient;
import com.krbr.KrbrOrder.dto.InventoryBatchDTO;
import com.krbr.KrbrOrder.dto.InventoryDTO;
import com.krbr.KrbrOrder.dto.request.CreateOrderRequest;
import com.krbr.KrbrOrder.dto.request.InventoryUpdateRequest;
import com.krbr.KrbrOrder.dto.request.UpdateInventoryRequest;
import com.krbr.KrbrOrder.dto.response.OrderResponse;
import com.krbr.KrbrOrder.entity.Order;
import com.krbr.KrbrOrder.entity.OrderStatus;
import com.krbr.KrbrOrder.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final SecureRandom RANDOM = new SecureRandom();


    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public OrderServiceImpl(InventoryClient inventoryClient, OrderRepository orderRepository) {
        this.inventoryClient = inventoryClient;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) throws Exception {
        Integer productId = createOrderRequest.getProductId();
        int quantity = createOrderRequest.getQuantity();

        InventoryDTO inventoryDTO = inventoryClient.getInventory(productId);

        List<InventoryBatchDTO> inventoryBatchDTOS = inventoryDTO.getBatches();


        Integer totalQty = 0;
        for(InventoryBatchDTO inventoryBatchDTO :  inventoryBatchDTOS) {
                totalQty += inventoryBatchDTO.getQuantity();
        }

        if (totalQty < quantity) {
            throw new Exception("Quantity is not available for the productId " + productId + " Available: " + totalQty + " and Asked" + quantity);
        }

        List<InventoryUpdateRequest> inventoryUpdateRequests = new ArrayList<>();

        for(InventoryBatchDTO inventoryBatchDTO :  inventoryBatchDTOS) {
            Integer qty = inventoryBatchDTO.getQuantity();
            Integer remainingQty = quantity >= qty ? 0 : qty - quantity;

            if(quantity >= qty) {
                quantity -= qty;

            } else {
                quantity = 0;
            }

            inventoryUpdateRequests.add(
                    new InventoryUpdateRequest(
                            inventoryBatchDTO.getBatchId(),
                            inventoryDTO.getProductId(),
                            inventoryDTO.getProductName(),
                            remainingQty,
                            inventoryBatchDTO.getExpiryDate()
                    )
            );

            if(quantity == 0) {
                break;
            }
        }

        Integer orderId = generate4DigitNumber();

        Order order = new Order(
                orderId,
                productId,
                inventoryDTO.getProductName(),
                createOrderRequest.getQuantity(),
                OrderStatus.PLACED,
                new Date()
        );

        orderRepository.save(order);

        System.out.println("order persisted in db");

        UpdateInventoryRequest updateInventoryRequest = new UpdateInventoryRequest(
                inventoryUpdateRequests
        );

        inventoryClient.updateInventory(updateInventoryRequest);

        return new OrderResponse(
                orderId,
                inventoryDTO.getProductId(),
                inventoryDTO.getProductName(),
                createOrderRequest.getQuantity(),
                OrderStatus.PLACED,
                "["+inventoryUpdateRequests.size()+"]",
                "Order placed. Inventory reserved."
        );
    }

    public static int generate4DigitNumber() {
        return 1000 + RANDOM.nextInt(9000);
    }
}
