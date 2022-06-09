package com.yedam.java.ch1201;

public class UserTest {

	public static void main(String[] args) throws InterruptedException {
		Calculator cal = new Calculator();
		
		cal.setMemory(100);
		
		User user1 = new User();
		user1.setCalculator(cal);
		user1.start();		// setMemory 200
		Thread.sleep(500);
		User user2 = new User();
		user2.setCalculator(cal);
		user2.start();		// setMemory 300
		// 
	}

}
