package com.wareHouse.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class WareHouseApplication {
	
	
	@Bean
	WebClient webClient(){
		
	return	WebClient.create("http://localhost:5000");
	}


	public static void main(String[] args) {
		SpringApplication.run(WareHouseApplication.class, args);
	}

}
