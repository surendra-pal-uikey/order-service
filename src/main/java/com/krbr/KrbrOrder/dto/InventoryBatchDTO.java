package com.krbr.KrbrOrder.dto;

import java.util.Date;

public class InventoryBatchDTO {
    private Integer batchId;
    private Integer quantity;
    private Date expiryDate;

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
