package com.yedam.java.example1;

public class Vip extends Customer{
	private double discountRatio;
	private String manager;
	
	public Vip() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		discountRatio = 0.15;
	}
	public Vip(int customerId, String customerName, String manager) {
		super(customerId, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		discountRatio = 0.15;
		this.manager = manager;
	}
	
	@Override
	public int calcPrice(int price) {
		bonusPoint += (price*bonusRatio);
		return (int)(price*(1-discountRatio));
	}
	@Override
	public String showInfo() {
		return super.showInfo() + "\n담당 상담원은 " + manager + "입니다.";
	}
	
	
	// getter setter
	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}
	public double getDiscountRatio() {
		return this.discountRatio;
	}
	public void setManager(String manager) {
		this.manager=manager;
	}
	public String getManager() {
		return this.manager;
	}
	
}
