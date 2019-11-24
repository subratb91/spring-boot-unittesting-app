package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SomeBusinessImplTest {
	
	@Test
	public void testCalculateSum_Basic() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		int actualResult = someBusinessImpl.calculateSum(new int[] {1,2,3});
		assertEquals(6,actualResult);
	}
	
	@Test
	public void testCalculateSum_EmptyIntArray() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		int actualResult = someBusinessImpl.calculateSum(new int[] {});
		assertEquals(0,actualResult);
	}
	
	@Test
	public void testCalculateSum_OneValue() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		int actualResult = someBusinessImpl.calculateSum(new int[] {5});
		assertEquals(5,actualResult);
	}

}
