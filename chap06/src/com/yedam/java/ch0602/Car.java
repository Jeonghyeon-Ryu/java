package com.yedam.java.ch0602;

public class Car {
	// field
	public String company = "현대자동차";;
	String model = "그랜저";;
	String color = "검정";;
	int maxSpeed = 350;
	int speed;
	
	public Car() { }
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
//		this("현대자동차",model,color);
	}
	public Car(String company, String model, String color) {
		this(model,color);
		this.company = company;
//		this.model = model;
//		this.color = color;
	}
}
