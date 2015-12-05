package com.java.amazon.model;

import java.util.ArrayList;
import java.util.List;

public class Friend {
	private int id;
	private String name;
	private List<Product> productsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProductsList() {
		if(productsList == null){
			productsList = new ArrayList<Product>();
		}
		
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
}