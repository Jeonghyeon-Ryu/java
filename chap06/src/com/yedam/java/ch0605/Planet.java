package com.yedam.java.ch0605;

public class Planet {
	//	Field
	static int radius;
	static final double pi = 3.14159;
	//	Constructor
	Planet(int radius){
		Planet.radius = radius;
	}
	
	//	Method
	void getArea() {
		double result = Planet.radius * Planet.radius * Planet.pi * 4;
		System.out.println("행성의 표면적 : " + result);
	}
}
