package com.krbr.KrbrOrder.service;

import com.krbr.KrbrOrder.dto.request.CreateOrderRequest;
import com.krbr.KrbrOrder.dto.response.OrderResponse;
import com.krbr.KrbrOrder.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public OrderResponse createOrder(CreateOrderRequest createOrderRequest) throws Exception;
}
