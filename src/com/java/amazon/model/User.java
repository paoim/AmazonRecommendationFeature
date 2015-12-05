package com.java.amazon.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private List<Friend> friendsList;

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

	public List<Friend> getFriendsList() {
		if (friendsList == null) {
			friendsList = new ArrayList<Friend>();
		}

		return friendsList;
	}

	public void setFriendsList(List<Friend> friendsList) {
		this.friendsList = friendsList;
	}
}