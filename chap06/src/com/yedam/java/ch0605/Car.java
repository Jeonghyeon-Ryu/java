package com.yedam.java.ch0605;

public class Car implements Runnable {
	// 필드
	String model;
	int speed;
	
	// 정적 필드 - 생산수량
	public static int count;
	
	// 생성자
	public Car(String model){
		this.model = model;
		Car.count++;
	}
	
	// 메소드
	void setSpeed(int speed) {
		this.speed = speed;
	}
	public void run() {
		for(int i=10; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다. (시속 : "+this.speed +"km/h)");
		}
	}
}