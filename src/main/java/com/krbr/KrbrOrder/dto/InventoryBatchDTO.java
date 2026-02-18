package com.krbr.KrbrOrder.dto;

import java.util.Date;

public class InventoryBatchDTO {
    private Integer batchId;
    private Integer quantity;
    private Date expiryDate;

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
