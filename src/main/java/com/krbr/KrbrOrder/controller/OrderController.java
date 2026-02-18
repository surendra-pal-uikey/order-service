package com.krbr.KrbrOrder.controller;

import com.krbr.KrbrOrder.dto.OrderDTO;
import com.krbr.KrbrOrder.dto.request.CreateOrderRequest;
import com.krbr.KrbrOrder.entity.Order;
import com.krbr.KrbrOrder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllInventory() {
        return orderService.getAllOrders().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        orderService.createOrder(createOrderRequest);
    }

    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(
                order.getOrderId(),
                order.getProductId(),
                order.getProductName(),
                order.getQuantity(),
                order.getStatus(),
                order.getOrderDate()
        );
    }
}
