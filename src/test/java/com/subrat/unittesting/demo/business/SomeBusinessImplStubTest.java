package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.subrat.unittesting.demo.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllDataForSum() {
		return new int[] { 1, 2, 3 };
	}

}

class SomeDataServiceStubEmptyArray implements SomeDataService {

	@Override
	public int[] retrieveAllDataForSum() {
		return new int[] {};
	}

}

class SomeDataServiceStubOneValue implements SomeDataService {

	@Override
	public int[] retrieveAllDataForSum() {
		return new int[] { 5 };
	}

}

public class SomeBusinessImplStubTest {

	@Test
	public void testCalculateSumUsingSomeDataService_Basic() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceStub());
		int actualResult = someBusinessImpl.calculateSumUsingSomeDataService();
		assertEquals(6, actualResult);
	}

	@Test
	public void testCalculateSumUsingSomeDataService_EmptyIntArray() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceStubEmptyArray());
		int actualResult = someBusinessImpl.calculateSumUsingSomeDataService();
		assertEquals(0, actualResult);
	}

	@Test
	public void testCalculateSumUsingSomeDataService_OneValue() {
		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceStubOneValue());
		int actualResult = someBusinessImpl.calculateSumUsingSomeDataService();
		assertEquals(5, actualResult);
	}

}
