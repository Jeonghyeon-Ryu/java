package com.yedam.homework;

public class Product {
	private String name;
	private int price;
	
	Product() { }
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// 전체 출력
	public String getName() {
		return name+" : "+price;
	}
	// 가격 출력
	public int getPrice() {
		return price;
	}
}
