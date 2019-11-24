package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.subrat.unittesting.demo.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockitoTest {
	
	@InjectMocks
	SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl();
	
	@Mock
	SomeDataService someDataService;


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
