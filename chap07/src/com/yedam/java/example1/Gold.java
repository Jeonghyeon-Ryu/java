package com.yedam.java.example1;

public class Gold extends Customer {
	private double discountRatio;
	
	public Gold() {
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		discountRatio = 0.1;
	}
	public Gold(int customerId, String customerName) {
		super(customerId, customerName);
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		discountRatio = 0.1;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += (price*bonusRatio);
		return (int)(price*(1-discountRatio));
	}

	// getter setter
	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	
}
