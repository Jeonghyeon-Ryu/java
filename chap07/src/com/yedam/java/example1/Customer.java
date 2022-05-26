package com.yedam.java.example1;

public class Customer {
	public int customerId;			// 아이디
	private String customerName;	// 이름
	protected String customerGrade;	// 등급
	protected int bonusPoint;			// 보너스포인트
	protected double bonusRatio;		// 포인트적립율
	
	public Customer() {
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	public Customer(int customerId, String customerName) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerGrade = "SILVER";
		this.bonusRatio = 0.01;
	}
	
	public int calcPrice(int price) {
		this.bonusPoint += (price*this.bonusRatio);
		return price;
	}
	
	public String showInfo() {
		return customerName +"님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerId() {
		return this.customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerName() {
		return this.customerName;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public String getCustomerGrade() {
		return this.customerGrade;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public int getBonusPoint() {
		return this.bonusPoint;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	public double getBonusRatio() {
		return this.bonusRatio;
	}
}
