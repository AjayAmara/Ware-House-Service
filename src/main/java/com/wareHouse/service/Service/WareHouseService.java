package com.wareHouse.service.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.wareHouse.service.Dtos.OrderDto;
import com.wareHouse.service.Dtos.ProductionEntry;
import com.wareHouse.service.Entity.DateDetails;
import com.wareHouse.service.Entity.InventoryEntity;
import com.wareHouse.service.repository.DateDetailsRepository;
import com.wareHouse.service.repository.InventoryRepository;

@Service
public class WareHouseService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private DateDetailsRepository dateDetailsRepository;

	@Value("${internalShelfLife}")
	private int internalShelfLife;
	
	@Autowired
	WebClient webClient;

	private static final Logger log = LoggerFactory.getLogger(WareHouseService.class);

	int itemId, quantity, dateId, stock, backOrder;
	String orderDate;

	public String checkTheInventory(OrderDto orderDto) {

	String statusList = null;
		

		

			itemId = orderDto.getItemId();
			quantity = orderDto.getQuantity();
			orderDate = orderDto.getOrderDate();

			log.info("order date..=" + orderDate);

			DateDetails dateObj = dateDetailsRepository.getByDateDim(orderDate);

			dateId = dateObj.getDateID();

			List<InventoryEntity> inventory1 = inventoryRepository.getByStockDate(dateId);
			log.info("inventory........." + inventory1);


			for (InventoryEntity inventory : inventory1) {

				if (inventory.getProductId() == itemId) {

					if (inventory.getStock() >= quantity && inventory.getStockDate() == dateId) {
						int stock = inventory.getStock();
						int updatedStock = stock - quantity;
						int previusReservation = inventory.getReservation();

						inventory.setReservation(previusReservation + quantity);
						inventory.setStock(updatedStock);
						inventory.setBackOrder(inventory.getBackOrder());
						inventory.setDeliveryFromProduction(inventory.getDeliveryFromProduction());
						inventory.setObsoletes(inventory.getObsoletes());
						inventory.setProductId(inventory.getProductId());
						inventory.setRejection(inventory.getRejection());
						inventory.setStartUpLose(inventory.getStartUpLose());
						inventory.setWarehouseId(inventory.getWarehouseId());

						inventoryRepository.save(inventory);
						statusList= "processed";

					} else {
						int previuseBackorder = inventory.getBackOrder();
						stock = inventory.getStock();
						backOrder = quantity - stock;
						int previusReservation = inventory.getReservation();
						inventory.setBackOrder(previuseBackorder + backOrder);
						inventory.setReservation(previusReservation + stock);
						inventory.setStock(0);
						inventory.setDeliveryFromProduction(inventory.getDeliveryFromProduction());
						inventory.setObsoletes(inventory.getObsoletes());
						inventory.setProductId(inventory.getProductId());
						inventory.setRejection(inventory.getRejection());
						inventory.setStartUpLose(inventory.getStartUpLose());
						inventory.setWarehouseId(inventory.getWarehouseId());

						statusList= "Back order";
						inventoryRepository.save(inventory);

					}

				}

			}



		
		return statusList;

	}

	public void addproduct(ProductionEntry productionEntry) {

		log.info("" + productionEntry);
		int productId=productionEntry.getProductId();
		//  List<OrderLineDto> orderLines=  webClient.post().uri("/orderLinesForBackOrders/"+productId) .retrieve().bodyToMono(List.class).block();
		
		//  log.info("orderLinesIn production"+orderLines);

		DateDetails dateObj = dateDetailsRepository.getByDateDim(productionEntry.getStockDate());
		dateId = dateObj.getDateID();

		List<InventoryEntity> inventoryEntity = inventoryRepository.getByStockDate(dateId);
		for (InventoryEntity inventoryEntity2 : inventoryEntity) {

			int backOrder, obsolets, rejection, stock, lose, production, finalStock, finalStock1, startUpLose;
			if (inventoryEntity2.getProductId() == productionEntry.getProductId()) {

				backOrder = inventoryEntity2.getBackOrder();
				obsolets = inventoryEntity2.getObsoletes();
				rejection = productionEntry.getRejection();
				production = productionEntry.getDeliveryFromProduction();
				startUpLose = productionEntry.getStartUpLose();
				lose = obsolets + rejection + startUpLose;
				
				stock = production - lose;
				
				finalStock = inventoryEntity2.getStock() + stock;
				
				if (finalStock >= backOrder) {
					finalStock1 = finalStock - backOrder;
					inventoryEntity2.setBackOrder(0);
					inventoryEntity2.setStock(finalStock1);
					
				//	modify(orderLines);
				
					
					 
				} else {
					
					
					inventoryEntity2.setStock(finalStock);
					inventoryEntity2.setBackOrder(inventoryEntity2.getBackOrder());
				}

				inventoryEntity2.setDeliveryFromProduction(production);
				inventoryEntity2.setProductId(productionEntry.getProductId());
				inventoryEntity2.setRejection(productionEntry.getRejection());
				inventoryEntity2.setStartUpLose(productionEntry.getStartUpLose());
				inventoryEntity2.setStockDate(dateId);
				inventoryEntity2.setWarehouseId(productionEntry.getWarehouseId());

				inventoryEntity2.setObsoletes(inventoryEntity2.getObsoletes());
				inventoryEntity2.setReservation(inventoryEntity2.getReservation());

				inventoryRepository.save(inventoryEntity2);
			}
		}
	}

	/*
	 * private void modify(List<OrderLineDto> orderLines) { int count=0;
	 * while(orderLines.size()>=0) { String team =
	 * webClient.post().uri("/modifyStatus/"+orderLines.get(count).
	 * getOrderLineNumber()).retrieve().bodyToMono(String.class).block(); count++; }
	 * 
	 * }
	 */

	public void updateTheInventory(String date) {

		DateDetails dateObj = dateDetailsRepository.getByDateDim(date);
		dateId = dateObj.getDateID();
		int yestDateId = dateId - 1;
		log.info("yestDateId............................." + yestDateId);

		List<InventoryEntity> inventort = inventoryRepository.getByStockDate(yestDateId);

		log.info("inventort............................." + inventort);

		for (InventoryEntity inventoryEntry : inventort) {
			InventoryEntity inventoryEntity = new InventoryEntity();
			inventoryEntity.setBackOrder(inventoryEntry.getBackOrder());
			inventoryEntity.setProductId(inventoryEntry.getProductId());
			inventoryEntity.setStock(inventoryEntry.getStock());
			inventoryEntity.setStockDate(dateId);
			inventoryEntity.setWarehouseId(inventoryEntry.getWarehouseId());

			inventoryRepository.save(inventoryEntity);

		}

		int obsoleteDateId = dateId - internalShelfLife;
		List<InventoryEntity> inventory = inventoryRepository.getByStockDate(obsoleteDateId);

		for (InventoryEntity inventoryEntity : inventory) {

			if (inventoryEntity.getStock() != 0) {
				int productId = inventoryEntity.getProductId();
				List<InventoryEntity> inventoryForToday = inventoryRepository.getByStockDate(dateId);
				for (InventoryEntity inventoryEntity2 : inventoryForToday) {

					if (inventoryEntity2.getProductId() == productId) {
						inventoryEntity2.setBackOrder(inventoryEntity2.getBackOrder());
						inventoryEntity2.setDeliveryFromProduction(inventoryEntity2.getDeliveryFromProduction());
						inventoryEntity2.setObsoletes(inventoryEntity.getStock());
						inventoryEntity2.setProductId(inventoryEntity2.getProductId());
						inventoryEntity2.setRejection(inventoryEntity2.getRejection());
						inventoryEntity2.setReservation(inventoryEntity2.getReservation());
						inventoryEntity2.setStartUpLose(inventoryEntity2.getStartUpLose());
						inventoryEntity2.setStock(inventoryEntity2.getStock());
						inventoryEntity2.setStockDate(inventoryEntity2.getStockDate());
						inventoryEntity2.setWarehouseId(inventoryEntity2.getWarehouseId());

						inventoryRepository.save(inventoryEntity2);
					}

				}

			}

			inventoryEntity.setBackOrder(inventoryEntity.getBackOrder());
			inventoryEntity.setDeliveryFromProduction(inventoryEntity.getDeliveryFromProduction());
			inventoryEntity.setObsoletes(inventoryEntity.getObsoletes());
			inventoryEntity.setProductId(inventoryEntity.getProductId());
			inventoryEntity.setRejection(inventoryEntity.getRejection());
			inventoryEntity.setReservation(inventoryEntity.getReservation());
			inventoryEntity.setStartUpLose(inventoryEntity.getStartUpLose());
			inventoryEntity.setStock(0);
			inventoryEntity.setStockDate(inventoryEntity.getStockDate());
			inventoryEntity.setWarehouseId(inventoryEntity.getWarehouseId());
			inventoryRepository.save(inventoryEntity);

		}

	}

}
