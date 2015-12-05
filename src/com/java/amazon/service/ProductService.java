package com.java.amazon.service;

import java.util.List;

import com.java.amazon.model.Friend;
import com.java.amazon.model.Product;
import com.java.amazon.model.User;

public interface ProductService {

	List<Product> getRecommendedProductsListForUser(User user);
	
	List<Product> getProductsListForUser(User user);

	List<Friend> getFriendsListForUser(User user);

	List<Product> getPurchasesForUser(Friend friend);

	void printProductsList(List<Product> productsList, String message);

}