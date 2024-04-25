package com.bloodBankDonorManagementSystem.Controller;
public class Stock {
	private String bloodGroup;
	private int stock;
	
	public Stock() {
		super();
	}

	public Stock(String bloodGroup, int stock) {
		super();
		this.bloodGroup = bloodGroup;
		this.stock = stock;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
