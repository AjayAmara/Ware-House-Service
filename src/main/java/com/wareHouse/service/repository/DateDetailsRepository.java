package com.wareHouse.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wareHouse.service.Entity.DateDetails;

public interface DateDetailsRepository extends JpaRepository<DateDetails, Integer> {

	

	DateDetails getByDateDim(String orderDate);

	

}
