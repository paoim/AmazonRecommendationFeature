package com.java.amazon.util;

import java.util.Comparator;

import com.java.amazon.model.Product;

public class ProductReNoComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {

		return ((o1.getRecommendationNo() >= o2.getRecommendationNo()) ? -1 : 1);
	}

}