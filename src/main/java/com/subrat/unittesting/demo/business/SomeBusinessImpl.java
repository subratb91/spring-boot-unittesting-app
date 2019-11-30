package com.subrat.unittesting.demo.business;

import java.util.Arrays;
import java.util.OptionalInt;

import com.subrat.unittesting.demo.data.SomeDataService;

public class SomeBusinessImpl {
	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
	
	public int calculateSumUsingFunctionalProgramming(int[] data) {
		OptionalInt optionalInt = Arrays.stream(data).reduce(Integer::sum);
		return optionalInt.orElse(0);
	}

	public int calculateSumUsingSomeDataService() {
		int[] data = someDataService.retrieveAllDataForSum();
		int sum = 0;
		for (int value : data) {
			sum += value;
		}
		return sum;
	}
}
