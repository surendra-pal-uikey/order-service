package com.krbr.KrbrOrder.service;

import com.krbr.KrbrOrder.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
}
