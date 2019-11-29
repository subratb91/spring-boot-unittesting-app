package com.subrat.unittesting.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subrat.unittesting.demo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
