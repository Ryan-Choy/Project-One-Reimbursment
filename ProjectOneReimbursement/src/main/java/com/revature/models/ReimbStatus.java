package com.revature.models;

public enum ReimbStatus {
	PENDING(1),
	APPROVED(2),
	DENIED(3);
	
	private final int value;
	
	private ReimbStatus(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
		
	
}
