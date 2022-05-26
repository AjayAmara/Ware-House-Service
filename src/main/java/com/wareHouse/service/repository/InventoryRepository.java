package com.wareHouse.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wareHouse.service.Dtos.InventoryDto;
import com.wareHouse.service.Entity.InventoryEntity;

public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer>{

	InventoryDto getByProductId(int itemId);

	List<InventoryEntity> getByStockDate(int dateId);

}
