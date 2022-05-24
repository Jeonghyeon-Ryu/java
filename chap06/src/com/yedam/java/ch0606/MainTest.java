package com.yedam.java.ch0606;

import com.yedam.java.ch0605.Car;

public class MainTest {

	public static void main(String[] args) {
		Car myCar = new Car("포르쉐");
		System.out.println(Car.count);
		myCar.run();
	}

}