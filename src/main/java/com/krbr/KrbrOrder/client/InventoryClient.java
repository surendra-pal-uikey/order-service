package com.krbr.KrbrOrder.client;

import com.krbr.KrbrOrder.config.InventoryServiceProperties;
import com.krbr.KrbrOrder.dto.InventoryDTO;
import com.krbr.KrbrOrder.dto.request.UpdateInventoryRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class InventoryClient {

    private final WebClient webClient;
    private final InventoryServiceProperties inventoryServiceProperties;

    public InventoryClient(WebClient webClient,
                           InventoryServiceProperties inventoryServiceProperties) {
        this.webClient = webClient;
        this.inventoryServiceProperties = inventoryServiceProperties;
    }

    public InventoryDTO getInventory(Integer productId) {
        return webClient.get()
                .uri(inventoryServiceProperties.getBaseUrl() + "/api/inventory/" + productId)
                .retrieve()
                .bodyToMono(InventoryDTO.class)
                .block();
    }

    public void updateInventory(UpdateInventoryRequest updateInventoryRequest) {
        webClient.post()
                .uri(inventoryServiceProperties.getBaseUrl() + "/api/inventory/update")
                .bodyValue(updateInventoryRequest)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
