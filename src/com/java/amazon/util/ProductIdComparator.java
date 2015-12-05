package com.java.amazon.util;

import java.util.Comparator;

import com.java.amazon.model.Product;

public class ProductIdComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {

		return ((o1.getId() >= o2.getId()) ? -1 : 1);
	}

}