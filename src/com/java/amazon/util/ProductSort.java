package com.java.amazon.util;

import java.util.List;

import com.java.amazon.model.Product;

public interface ProductSort {

	List<Product> getBubbleSortProductsById(List<Product> productsList, boolean isAsc);

	List<Product> getBubbleSortProductsByReNo(List<Product> productsList, boolean isAsc);

	List<Product> getQuickSortProductsById(List<Product> productsList, boolean isAsc);

	List<Product> getQuickSortProductsByReNo(List<Product> productsList, boolean isAsc);

}