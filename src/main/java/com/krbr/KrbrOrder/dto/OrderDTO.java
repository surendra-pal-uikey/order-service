package com.krbr.KrbrOrder.dto;

import com.krbr.KrbrOrder.entity.OrderStatus;

import java.util.Date;

public class OrderDTO {
    private Integer orderId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private OrderStatus status;
    private Date orderDate;

    public OrderDTO() {}

    public OrderDTO(Integer orderId, Integer productId, String productName, Integer quantity, OrderStatus status, Date orderDate) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
