package com.subrat.unittesting.demo.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void contextLoads() throws JSONException {
		String itemsResponse = this.testRestTemplate.getForObject("/all-items", String.class);
		JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", itemsResponse, false);
	}
	
	
	

}
