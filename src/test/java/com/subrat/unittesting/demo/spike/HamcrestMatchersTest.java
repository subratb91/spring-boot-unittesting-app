package com.subrat.unittesting.demo.spike;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class HamcrestMatchersTest {
	
	@Test
	@Ignore
	public void learning() {
		List<Integer> integersList = Arrays.asList(12,15,45);
		assertThat(integersList,hasSize(3));
		assertThat(integersList,hasItems(12,45));
		assertThat(integersList,everyItem(greaterThan(10)));
		assertThat(integersList,everyItem(lessThan(10)));
		
		assertThat("", isEmptyString());
		assertThat("ABCDE", containsString("BCD"));
		assertThat("ABCDE", startsWith("ABC"));
		assertThat("ABCDE", endsWith("CDE"));
	}

}
