package com.krbr.KrbrOrder.service;

import com.krbr.KrbrOrder.dto.request.CreateOrderRequest;
import com.krbr.KrbrOrder.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public void createOrder(CreateOrderRequest createOrderRequest);
}
