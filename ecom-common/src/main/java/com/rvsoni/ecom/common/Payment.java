package com.rvsoni.ecom.common;

import java.util.UUID;

public class Payment {

	private UUID id;
	
	private String amount;
	
	private User user;
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(UUID id, String amount, User user) {
		super();
		this.id = id;
		this.amount = amount;
		this.user = user;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
