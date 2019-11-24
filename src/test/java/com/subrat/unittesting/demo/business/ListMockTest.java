package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class ListMockTest {
	List<String> mockList = mock(List.class);

	@Test
	public void testList_sizeBasic() {
		when(mockList.size()).thenReturn(5);
		assertEquals(5, mockList.size());
	}

	@Test
	public void testList_differentSizes() {
		when(mockList.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mockList.size());
		assertEquals(10, mockList.size());
	}

	@Test
	public void testList_returnElementsWithParam() {
		when(mockList.get(0)).thenReturn("Github");
		assertEquals("Github", mockList.get(0));
		assertEquals(null, mockList.get(1));
	}

	// anyInt() is an ArgumentMatchers
	@Test
	public void testList_returnElementsWithGenericParam() {
		when(mockList.get(Mockito.anyInt())).thenReturn("Github");
		assertEquals("Github", mockList.get(0));
		assertEquals("Github", mockList.get(1));
		assertEquals("Github", mockList.get(3));
		assertNotEquals("Not Github", mockList.get(4));
	}

	@Test
	public void verificationBasics() {
		// SUT
		String value1 = mockList.get(0);
		String value2 = mockList.get(1);

		// Verify
		verify(mockList).get(0);
		verify(mockList, times(2)).get(Mockito.anyInt());
		verify(mockList, atLeast(1)).get(Mockito.anyInt());
		verify(mockList, atLeastOnce()).get(Mockito.anyInt());
		verify(mockList, atMost(2)).get(Mockito.anyInt());
		verify(mockList, never()).get(2);
	}

	@Test
	public void argumentCapturing() {
		// SUT
		mockList.add("BitBucket");

		// Verification
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockList).add(argCaptor.capture());

		assertEquals("BitBucket", argCaptor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		// SUT
		mockList.add("BitBucket1");
		mockList.add("BitBucket2");

		// Verification
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockList,times(2)).add(argCaptor.capture());
		List<String> allValuesFromCaptor = argCaptor.getAllValues();

		assertEquals("BitBucket1", allValuesFromCaptor.get(0));
		assertEquals("BitBucket2", allValuesFromCaptor.get(1));
	}
	
	@Test
	public void arrayListMock() {
		//Mock resembles mock objects
		ArrayList<String> mockArrayList = mock(ArrayList.class);
		mockArrayList.add("BitBucket1");
		mockArrayList.add("BitBucket2");
		assertNotEquals(2, mockArrayList.size());
		System.out.println(mockArrayList.size());  //0 - default value
		mockArrayList.add("BitBucket3");
		assertNotEquals(3, mockArrayList.size());
		System.out.println(mockArrayList.size());  //0 - default value
		when(mockArrayList.size()).thenReturn(5);
		mockArrayList.add("BitBucket4");
		System.out.println(mockArrayList.size());  //5 - after when
		verify(mockArrayList).add("BitBucket3");
		assertEquals(5, mockArrayList.size());
	}
	
	@Test
	public void arrayListSpy() {
		//Spy resembles real world objects
		ArrayList<String> spyArrayList = spy(ArrayList.class);
		spyArrayList.add("BitBucket1");
		spyArrayList.add("BitBucket2");
		assertEquals(2, spyArrayList.size());
		System.out.println(spyArrayList.size());  //2
		spyArrayList.add("BitBucket3");
		assertEquals(3, spyArrayList.size());
		System.out.println(spyArrayList.size());  //3
		when(spyArrayList.size()).thenReturn(5);
		spyArrayList.add("BitBucket4");
		System.out.println(spyArrayList.size());  //5 - after when
		verify(spyArrayList).add("BitBucket3");
		assertEquals(5, spyArrayList.size());
	}

}
