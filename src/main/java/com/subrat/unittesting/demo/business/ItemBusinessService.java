package com.subrat.unittesting.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subrat.unittesting.demo.data.ItemRepository;
import com.subrat.unittesting.demo.model.Item;

@Service
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;

	public Item getHardcodedDummyItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> getAllItems() {
		List<Item> allItems = itemRepository.findAll();
		for (Item item : allItems) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return allItems;
	}

	public void createItem(Item item) {
		itemRepository.save(item);
	}

}
