package com.krbr.KrbrOrder.service;

import com.krbr.KrbrOrder.client.InventoryClient;
import com.krbr.KrbrOrder.dto.InventoryDTO;
import com.krbr.KrbrOrder.dto.request.CreateOrderRequest;
import com.krbr.KrbrOrder.entity.Order;
import com.krbr.KrbrOrder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public OrderServiceImpl(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void createOrder(CreateOrderRequest createOrderRequest) {
        Integer productId = createOrderRequest.getProductId();
        Integer quantity = createOrderRequest.getQuantity();

        System.out.println("productId " + productId);
        System.out.println("quantity " + quantity);

        List<InventoryDTO> inventoryDTOS = inventoryClient.getInventory(productId);

        System.out.println(inventoryDTOS);
    }
}
