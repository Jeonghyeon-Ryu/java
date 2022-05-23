package com.yedam.java.ch0602;

public class Main {

	public static void main(String[] args) {
		Car myCar = new Car();
		System.out.println(myCar.company);
		System.out.println(myCar.color);
		System.out.println(myCar.model);
		System.out.println(myCar.maxSpeed);
		myCar.speed = 100;
		System.out.println(myCar.speed);
		System.out.println("------------");
		Car yourCar = new Car("기아", "아반떼", "파란색");
		System.out.println(yourCar.company);
		System.out.println(yourCar.color);
		System.out.println(yourCar.model);
		System.out.println(yourCar.maxSpeed);
		System.out.println(yourCar.speed);
		System.out.println("------------");
		Car moha = new Car("모하비","흰색");
		System.out.println(moha.company);
		System.out.println(moha.model);
		System.out.println(moha.color);
		
	}

}
