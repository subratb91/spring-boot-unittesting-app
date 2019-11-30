package com.subrat.unittesting.demo.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.subrat.unittesting.demo.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void testFindAll_basic() {
		List<Item> itemsList = itemRepository.findAll();
		assertEquals(3, itemsList.size());
		assertEquals("Item10001", itemsList.get(0).getName());
	}

}
