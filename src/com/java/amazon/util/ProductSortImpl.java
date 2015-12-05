package com.java.amazon.util;

import java.util.ArrayList;
import java.util.List;

import com.java.amazon.model.Product;

public class ProductSortImpl implements ProductSort {

	public List<Product> getBubbleSortProductsById(List<Product> productsList,boolean isAsc) {
		int size = productsList.size();

		if (size <= 1) {
			return productsList;
		}

		Product temp = null;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 1; j < size - i; j++) {
				if (productsList.get(j - 1).getId() > productsList.get(j).getId()) {
					// swap the elements
					temp = productsList.get(j - 1);
					productsList.set(j - 1, productsList.get(j));
					productsList.set(j, temp);
				}
			}
		}

		return productsList;
	}

	public List<Product> getBubbleSortProductsByReNo(List<Product> productsList,boolean isAsc) {
		int size = productsList.size();

		if (size <= 1) {
			return productsList;
		}

		Product temp = null;
		for (int i = 0; i < size - 1; i++) {
			for (int j = 1; j < size - i; j++) {
				if (productsList.get(j - 1).getRecommendationNo() > productsList.get(j).getRecommendationNo()) {
					// swap the elements
					temp = productsList.get(j - 1);
					productsList.set(j - 1, productsList.get(j));
					productsList.set(j, temp);
				}
			}
		}

		return productsList;
	}

	public List<Product> getQuickSortProductsById(List<Product> productsList, boolean isAsc) {
		int size = productsList.size();

		if (size <= 1) {
			return productsList;
		}

		int middle = (int) Math.ceil((double) size / 2);
		Product pivot = productsList.get(middle);

		List<Product> less = new ArrayList<Product>();
		List<Product> greater = new ArrayList<Product>();

		for (int i = 0; i < size; i++) {
			boolean sortByAsc = (isAsc ? (productsList.get(i).getId() <= pivot.getId()) : (productsList.get(i).getId() >= pivot.getId()));
			if (sortByAsc) {
				if (i == middle) {
					continue;
				}

				less.add(productsList.get(i));
			} else {
				greater.add(productsList.get(i));
			}
		}

		getQuickSortProductsById(less, isAsc);
		getQuickSortProductsById(greater, isAsc);

		productsList.clear();
		productsList.addAll(less);
		productsList.add(pivot);
		productsList.addAll(greater);

		return productsList;
	}

	public List<Product> getQuickSortProductsByReNo(List<Product> productsList,boolean isAsc) {
		int size = productsList.size();

		if (size <= 1) {
			return productsList;
		}

		int middle = (int) Math.ceil((double) size / 2);
		Product pivot = productsList.get(middle);

		List<Product> less = new ArrayList<Product>();
		List<Product> greater = new ArrayList<Product>();

		for (int i = 0; i < size; i++) {
			boolean sortByAsc = (isAsc ? (productsList.get(i).getRecommendationNo() <= pivot.getRecommendationNo()) : (productsList.get(i).getRecommendationNo() >= pivot.getRecommendationNo()));
			if (sortByAsc) {
				if (i == middle) {
					continue;
				}

				less.add(productsList.get(i));
			} else {
				greater.add(productsList.get(i));
			}
		}

		getQuickSortProductsByReNo(less, isAsc);
		getQuickSortProductsByReNo(greater, isAsc);

		productsList.clear();
		productsList.addAll(less);
		productsList.add(pivot);
		productsList.addAll(greater);

		return productsList;
	}
}