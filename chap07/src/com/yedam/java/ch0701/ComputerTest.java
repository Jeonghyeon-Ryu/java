package com.yedam.java.ch0701;

public class ComputerTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println("Calculator Area : " + cal.areaCircle(10));
		Computer com = new Computer();
		System.out.println("Computer Area : " + com.areaCircle(10));
	}

}
