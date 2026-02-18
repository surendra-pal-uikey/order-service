package com.krbr.KrbrOrder.dto.request;

import java.util.Date;

public class InventoryUpdateRequest {
    private Integer batchId;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Date expiryDate;

    public InventoryUpdateRequest(Integer batchId, Integer productId, String productName, Integer quantity, Date expiryDate) {
        this.batchId = batchId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
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

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}
