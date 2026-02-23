package com.krbr.KrbrOrder;

import com.krbr.KrbrOrder.client.InventoryClient;
import com.krbr.KrbrOrder.dto.InventoryBatchDTO;
import com.krbr.KrbrOrder.dto.InventoryDTO;
import com.krbr.KrbrOrder.dto.request.CreateOrderRequest;
import com.krbr.KrbrOrder.dto.request.InventoryUpdateRequest;
import com.krbr.KrbrOrder.dto.request.UpdateInventoryRequest;
import com.krbr.KrbrOrder.dto.response.OrderResponse;
import com.krbr.KrbrOrder.entity.Order;
import com.krbr.KrbrOrder.entity.OrderStatus;
import com.krbr.KrbrOrder.repository.OrderRepository;
import com.krbr.KrbrOrder.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	@Mock
	private InventoryClient inventoryClient;

	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private OrderServiceImpl orderServiceImpl;

	private Order generateOrder(int itr) {
		Order order = new Order();
		order.setOrderId(itr+1);
		order.setOrderDate(new Date());
		order.setProductId(itr*10);
		order.setQuantity(itr*10);
		order.setStatus(OrderStatus.PLACED);
		order.setProductName(String.valueOf(10*itr));

		return order;
	}


	private List<Order> generateMockData(int totalOrders) {
		ArrayList<Order> orderList = new ArrayList<>();

		for(int i = 0; i < totalOrders; i++) {
			orderList.add(generateOrder(i+1));
		}

		return orderList;
	}

	private Date generateExpDate(int day) {
		LocalDate today = LocalDate.now();

		TemporalAmount amount = Period.ofDays(day);

		LocalDate expDate = today.plus(amount);

		Instant i = expDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();

		return java.util.Date.from(i);
	}

	@Test
	void returnTotalOrder() {

		List<Order> orderList = generateMockData(3);
		when(orderRepository.findAll())
				.thenReturn(orderList);

		// when
		List<Order> result =
				orderServiceImpl.getAllOrders();

		// then
		assertNotNull(result);
		assertEquals(3, result.size());
	}

	@Test
	void createOrder() throws Exception {
		List<Order> orderList = generateMockData(5);
		int productId = 10;
		int quantity = 5;

		List<InventoryBatchDTO> inventoryBatchDTOS = new ArrayList<>();

		for(int i = 0; i < 2; i++) {
			InventoryBatchDTO inventoryBatchDTO = new InventoryBatchDTO();
			inventoryBatchDTO.setBatchId(1);
			inventoryBatchDTO.setQuantity(10);
			inventoryBatchDTO.setExpiryDate(generateExpDate(i+1));

			inventoryBatchDTOS.add(inventoryBatchDTO);
		}

		InventoryDTO inventoryDTO = new InventoryDTO();
		inventoryDTO.setProductId(productId);
		inventoryDTO.setProductName(String.valueOf(productId));
		inventoryDTO.setBatches(inventoryBatchDTOS);


		when(inventoryClient.getInventory(productId))
				.thenReturn(inventoryDTO);

		doNothing()
				.when(inventoryClient)
				.updateInventory(any(UpdateInventoryRequest.class));

		when(orderRepository.save(any(Order.class)))
				.thenReturn(any(Order.class));

		CreateOrderRequest createOrderRequest = new CreateOrderRequest();
		createOrderRequest.setProductId(productId);
		createOrderRequest.setQuantity(quantity);

		OrderResponse orderResponse =  orderServiceImpl.createOrder(createOrderRequest);
		assertEquals(5, orderResponse.getQuantity());

	}

}
