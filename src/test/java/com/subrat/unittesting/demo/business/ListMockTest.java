package com.subrat.unittesting.demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

public class ListMockTest {
	List<Integer> mockList = mock(List.class);

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
		when(mockList.get(0)).thenReturn(5);
		assertEquals(5, mockList.get(0));
		assertEquals(null, mockList.get(1));
	}
	
	
	//anyInt() is an ArgumentMatchers
	@Test
	public void testList_returnElementsWithGenericParam() {
		when(mockList.get(Mockito.anyInt())).thenReturn(5);
		assertEquals(5, mockList.get(0));
		assertEquals(5, mockList.get(1));
		assertEquals(5, mockList.get(3));
		assertNotEquals(4, mockList.get(4));
	}
	
	@Test
	public void verificationBasics() {
		//SUT
		Integer value1 = mockList.get(0);
		Integer value2 = mockList.get(1);
		
		//Verify
		verify(mockList).get(0);
		verify(mockList,times(2)).get(Mockito.anyInt());
		verify(mockList,atLeast(1)).get(Mockito.anyInt());
		verify(mockList,atLeastOnce()).get(Mockito.anyInt());
		verify(mockList,atMost(2)).get(Mockito.anyInt());
		verify(mockList,never()).get(2);
	}

}
