package com.yedam.java.ch0701;

public class Computer extends Calculator {
	// Java Annotation
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체");
		return Math.PI*r*r;
	}
}
