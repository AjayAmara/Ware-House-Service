package com.wareHouse.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wareHouse.service.Dtos.OrderDto;
import com.wareHouse.service.Dtos.ProductionEntry;
import com.wareHouse.service.Service.WareHouseService;

@Controller
public class WareHouseController {
	
	@Autowired
	WareHouseService wareHouseService; 
	
	 @RequestMapping("/")
	    public String home() {
		 
	        System.out.println("Going home...");
	        return "home";
	    }
	 
	 @GetMapping("/showForm")
	 public String showForm( Model model ) {
		 ProductionEntry entry = new ProductionEntry();
		    
		    model.addAttribute("entry", entry);
		    
		   
		    return "entry_form";
		}
	
	@PostMapping("/enterTheProduct")
	public String productionEntry(@ModelAttribute("entry") ProductionEntry entry) {
		
		wareHouseService.addproduct(entry);
		
		return "entry_success";

	}
	
	@PutMapping("/updateTheStock/{date}")
	public String updateTheInventory(@PathVariable String date) {
		
		wareHouseService.updateTheInventory(date);
		
		return "entry_success";
		
		
	}

	@PostMapping("/checkStatus")
	@ResponseBody
	public String checkInventory(@RequestBody OrderDto orderDto) {
		
		   
		   
		    return  wareHouseService.checkTheInventory(orderDto);
		   
	}
	
	

}
