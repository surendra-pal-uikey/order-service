package com.krbr.KrbrOrder.dto.response;

import com.krbr.KrbrOrder.entity.OrderStatus;

public class OrderResponse {
    private Integer orderId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private OrderStatus status;
    private String reservedFromBatchIds;
    private String message;

    public OrderResponse() {}

    public OrderResponse(Integer orderId, Integer productId, String productName, Integer quantity, OrderStatus status, String reservedFromBatchIds, String message) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.reservedFromBatchIds = reservedFromBatchIds;
        this.message = message;
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

    public String getReservedFromBatchIds() {
        return reservedFromBatchIds;
    }

    public void setReservedFromBatchIds(String reservedFromBatchIds) {
        this.reservedFromBatchIds = reservedFromBatchIds;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
