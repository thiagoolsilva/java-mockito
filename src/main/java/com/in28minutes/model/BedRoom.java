package com.in28minutes.model;

import java.util.List;

public class BedRoom {

	private String name;

	private List<RestRoom> restroom;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RestRoom> getRestroom() {
		return restroom;
	}

	public void setRestroom(List<RestRoom> restroom) {
		this.restroom = restroom;
	}
}
