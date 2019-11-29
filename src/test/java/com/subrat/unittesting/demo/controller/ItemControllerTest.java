package com.subrat.unittesting.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.subrat.unittesting.demo.business.ItemBusinessService;
import com.subrat.unittesting.demo.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService itemBusinessService;

	@Test
	public void testGetDummyItem_Basic() throws Exception {

		MockHttpServletRequestBuilder mockMvcRequest = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(mockMvcRequest)
				.andExpect(status().isOk())
				//.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andExpect(content().json("{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();

		//assertEquals("Hello World", mvcResult.getResponse().getContentAsString());

	}
	
	@Test
	public void testGetDummyItemFromService_Basic() throws Exception {
		
		when(itemBusinessService.getHardcodedDummyItem()).thenReturn(new Item(2, "Item2", 10, 100));

		MockHttpServletRequestBuilder mockMvcRequest = MockMvcRequestBuilders
				.get("/dummy-item-from-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(mockMvcRequest)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:Item2,price:10}"))
				.andReturn();
	}
	
	@Test
	public void testGetAllItems_Basic() throws Exception {
		
		when(itemBusinessService.getAllItems()).thenReturn(Arrays.asList(new Item(2, "Item2", 10, 100),new Item(3, "Item3", 20, 200)));

		MockHttpServletRequestBuilder mockMvcRequest = MockMvcRequestBuilders
				.get("/all-items")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(mockMvcRequest)
				.andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:Item2,price:10},{id:3,name:Item3,price:20}]"))
				.andReturn();
	}

}
