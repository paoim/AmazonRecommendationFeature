package com.java.amazon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.java.amazon.model.Friend;
import com.java.amazon.model.Product;
import com.java.amazon.model.User;
import com.java.amazon.util.ProductSort;
import com.java.amazon.util.ProductSortImpl;
import com.java.amazon.util.ProductsMapComparator;

public class ProductServiceImpl implements ProductService {

	private ProductSort sort = new ProductSortImpl();

	public List<Product> getRecommendedProductsListForUser(User user) {
		// Get all user's friends
		List<Friend> friendsList = getFriendsListForUser(user);

		// Get all products list from all user's friends
		List<Product> allProductsList = new ArrayList<Product>();
		for (Friend friend : friendsList) {
			allProductsList.addAll(getPurchasesForUser(friend));
		}

		// Count products by ID
		Map<Product, Integer> productsMap = new HashMap<Product, Integer>();
		for (Product product : allProductsList) {
			Integer count = productsMap.get(product);
			productsMap.put(product, ((count == null) ? 1 : (count + 1)));
		}

		// Sort products from high to low rank
		Map<Product, Integer> sortProductsMap = new TreeMap<Product, Integer>(
				new ProductsMapComparator(productsMap));
		sortProductsMap.putAll(productsMap);

		// Get all recommendation products list
		List<Product> recommendationsList = new ArrayList<Product>();
		for (Map.Entry<Product, Integer> entry : sortProductsMap.entrySet()) {
			Product product = entry.getKey();
			product.setRecommendationNo(entry.getValue());

			recommendationsList.add(product);
		}

		return recommendationsList;
	}

	public List<Product> getProductsListForUser(User user) {
		// Get all user's friends
		List<Friend> friendsList = getFriendsListForUser(user);

		// Get all products list from all user's friends
		List<Product> productsList = new ArrayList<Product>();
		for (Friend friend : friendsList) {
			productsList.addAll(getPurchasesForUser(friend));
		}

		// Sort products list by Quick sort
		List<Product> sortProductsList = sort.getQuickSortProductsById(productsList, true);

		// Count products list by ID
		List<Product> productsListCount = getProductsListCount(sortProductsList);
		
		// Sort recommendation products list from high to low
		productsList.clear();
		productsList.addAll(sort.getQuickSortProductsByReNo(productsListCount, false));

		return productsList;
	}

	protected List<Product> getProductsListCount(List<Product> sortProductsList) {
		int index = 1, count = 1;
		int productId = sortProductsList.get(0).getId();
		List<Product> productsListCount = new ArrayList<Product>();

		while (index < sortProductsList.size()) {
			if (productId == sortProductsList.get(index).getId()) {
				count++;
			} else {
				Product product = getProductById(sortProductsList, productId);
				product.setRecommendationNo(count);
				productsListCount.add(product);

				productId = sortProductsList.get(index).getId();
				count = 1;
			}

			index++;
		}
		return productsListCount;
	}

	protected Product getProductById(List<Product> productsList, int id) {
		Product product = null;

		for (Product prod : productsList) {
			if (prod.getId() == id) {
				product = prod;
			}
		}

		return product;
	}

	public List<Friend> getFriendsListForUser(User user) {

		return user.getFriendsList();
	}

	public List<Product> getPurchasesForUser(Friend friend) {

		return friend.getProductsList();
	}

	public void printProductsList(List<Product> productsList, String message) {
		System.out.println("============ " + message + " ============");
		for (Product product : productsList) {
			System.out.println("Product's ID[" + product.getId() + "] = "
					+ product.getRecommendationNo());
		}
	}
}