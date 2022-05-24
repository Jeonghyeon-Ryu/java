package com.yedam.java.ch0605;

public class CarTest {

	public static void main(String[] args) {
		System.out.println(Car.count);
		Car myCar = new Car("포르쉐");
		System.out.println(Car.count);
		Car yourCar = new Car("벤츠");
		System.out.println(Car.count);
		
		CarTest test = new CarTest();
		test.print();
		
		myCar.run();
		yourCar.run();
	}
	
	public void print() {
		System.out.println("인스턴스 메소드 입니다.");
	}
}
