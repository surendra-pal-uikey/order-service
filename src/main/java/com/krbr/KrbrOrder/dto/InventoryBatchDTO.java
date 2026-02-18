package com.krbr.KrbrOrder.dto;

import java.util.Date;

public class InventoryBatchDTO {
    private Integer batchId;
    private String quantity;
    private Date expiryDate;

    public Integer getBatchId() {
        return batchId;
    }

    public String getQuantity() {
        return quantity;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }
}
