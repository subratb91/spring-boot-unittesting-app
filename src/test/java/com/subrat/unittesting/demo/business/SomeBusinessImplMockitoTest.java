package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.subrat.unittesting.demo.data.SomeDataService;

public class SomeBusinessImplMockitoTest {

	SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
	SomeDataService someDataService = mock(SomeDataService.class);

	@Before
	public void before() {
		someBusinessImpl.setSomeDataService(someDataService);
	}

	@Test
	public void testCalculateSumUsingSomeDataService_Basic() {
		when(someDataService.retrieveAllDataForSum()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, someBusinessImpl.calculateSumUsingSomeDataService());
	}

	@Test
	public void testCalculateSumUsingSomeDataService_EmptyIntArray() {
		when(someDataService.retrieveAllDataForSum()).thenReturn(new int[] {});
		assertEquals(0, someBusinessImpl.calculateSumUsingSomeDataService());
	}

	@Test
	public void testCalculateSumUsingSomeDataService_OneValue() {
		when(someDataService.retrieveAllDataForSum()).thenReturn(new int[] { 1 });
		assertEquals(1, someBusinessImpl.calculateSumUsingSomeDataService());
	}

}
