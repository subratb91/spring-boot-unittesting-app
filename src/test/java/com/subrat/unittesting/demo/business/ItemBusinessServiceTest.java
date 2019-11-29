package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.subrat.unittesting.demo.data.ItemRepository;
import com.subrat.unittesting.demo.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	private ItemBusinessService itemBusinessService;

	@Mock
	private ItemRepository itemRepository;

	@Test
	public void testGetAllItems_Basic() {
		when(itemRepository.findAll())
				.thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100), new Item(3, "Item3", 20, 200)));
		List<Item> allItems = itemBusinessService.getAllItems();
		assertEquals(1000, allItems.get(0).getValue());
		assertEquals(4000, allItems.get(1).getValue());
	}

}
