package com.yedam.java.ch0802;

public class CarTest {
	public static void main(String[] args) {
		Car myCar = new Car();
		
		myCar.run();
		
//		myCar.frontLeftTire.test
		System.out.println(myCar.frontLeftTire instanceof HankookTire);
		
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		System.out.println();
		myCar.run();
	}
}
