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

    public OrderResponse(Integer orderId, Integer productId, String productName, Integer quantity, OrderStatus status, String reservedFromBatchIds, String message) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.reservedFromBatchIds = reservedFromBatchIds;
        this.message = message;
    }
}
