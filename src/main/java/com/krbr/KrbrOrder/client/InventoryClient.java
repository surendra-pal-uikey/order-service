package com.krbr.KrbrOrder.client;

import com.krbr.KrbrOrder.config.InventoryServiceProperties;
import com.krbr.KrbrOrder.dto.InventoryDTO;
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

    public List<InventoryDTO> getInventory(Integer productId) {
        return webClient.get()
                .uri(inventoryServiceProperties.getBaseUrl() + "/inventory/" + productId)
                .retrieve()
                .bodyToFlux(InventoryDTO.class)
                .collectList()
                .block();
    }
}
