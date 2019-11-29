package com.subrat.unittesting.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subrat.unittesting.demo.business.ItemBusinessService;
import com.subrat.unittesting.demo.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemBusinessService itemBusinessService;

	@GetMapping("/dummy-item")
	public Item getDummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	@GetMapping("/dummy-item-from-service")
	public Item getDummyItemFromService() {
		return itemBusinessService.getHardcodedDummyItem();
	}
	
	@GetMapping("/all-items")
	public List<Item> getAllItems(){
		/*for(Item item : allItems) {
			item.setValue(item.getPrice()* item.getQuantity());
		}*/
		return itemBusinessService.getAllItems();
	}

}
