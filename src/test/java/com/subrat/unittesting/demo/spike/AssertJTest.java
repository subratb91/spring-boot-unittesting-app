package com.subrat.unittesting.demo.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {
	
	@Test
	public void learning() {
		List<Integer> integerList = Arrays.asList(12,40,68);
		assertThat(integerList)
					.hasSize(3)
					.contains(12,68)
					.allMatch(integer -> integer > 10)
					.allMatch(integer -> integer < 100)
					.noneMatch(integer -> integer < 0);
		
		
		assertThat("").isEmpty();
		assertThat("ABCDE")
				.contains("BCD")
				.startsWith("ABC")
				.endsWith("DE");
	}

}
