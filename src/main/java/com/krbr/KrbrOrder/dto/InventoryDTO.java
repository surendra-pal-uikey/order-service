package com.krbr.KrbrOrder.dto;

import java.util.List;

public class InventoryDTO {
    private Integer productId;
    private String productName;
    private List<InventoryBatchDTO> batches;

    // Constructors
    public InventoryDTO() {}


    public InventoryDTO(Integer productId, String productName, List<InventoryBatchDTO> batches) {
        this.productId = productId;
        this.productName = productName;
        this.batches = batches;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public List<InventoryBatchDTO> getBatches() {
        return batches;
    }
}
