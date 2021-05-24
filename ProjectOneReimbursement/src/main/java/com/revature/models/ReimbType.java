	package com.revature.models;

public enum ReimbType {
	
	LODGING(1),
	TRAVEL(2),
	FOOD(3),
	OTHER(4);

	private final int value;
	
	private ReimbType(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}

}
