package com.subrat.unittesting.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	int id;
	String name;
	int price;
	int quantity;

}
