package com.subrat.unittesting.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subrat.unittesting.demo.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/dummy-item")
	public Item getDummyItem() {
		return new Item(1,"Ball", 10, 100);
	}

}
