package com.krbr.KrbrOrder.dto.request;

import java.util.List;

public class UpdateInventoryRequest {
    private List<InventoryUpdateRequest> inventoryUpdateRequests;

    public UpdateInventoryRequest(List<InventoryUpdateRequest> inventoryUpdateRequests) {
        this.inventoryUpdateRequests = inventoryUpdateRequests;
    }

    public List<InventoryUpdateRequest> getInventoryUpdateRequests() {
        return inventoryUpdateRequests;
    }

    public void setInventoryUpdateRequests(List<InventoryUpdateRequest> inventoryUpdateRequests) {
        this.inventoryUpdateRequests = inventoryUpdateRequests;
    }
}
