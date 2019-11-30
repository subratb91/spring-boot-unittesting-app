package com.subrat.unittesting.demo.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		String responseString = "[" +
				"{\"id\":10000,\"name\":\"Pencil\",\"price\":1000,\"quantity\":5}" + 
				"{\"id\":10001,\"name\":\"Pen\",\"price\":1000,\"quantity\":15}" +
				"{\"id\":10002,\"name\":\"Eraser\",\"price\":1000,\"quantity\":10}" +
				"]";
		
		DocumentContext context = JsonPath.parse(responseString);
		
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> idList = context.read("$..id");
		assertThat(idList).contains(10000,10001,10002);
		
		System.out.println("$.length() >>> " + context.read("$.length()").toString());
		System.out.println("$..id >>> " + context.read("$..id").toString());
		System.out.println("$.[1] >>> " + context.read("$.[1]").toString());
		System.out.println("$.[0:1] >>> " + context.read("$.[0:1]").toString());
		System.out.println("$.[0:2] >>> " + context.read("$.[0:2]").toString());
		System.out.println("$.[?(@.name=='Eraser')] >>> " + context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println("$.[?(@.quantity==5)] >>> " + context.read("$.[?(@.quantity==5)]").toString());
		
	}

}
