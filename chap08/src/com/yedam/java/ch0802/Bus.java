package com.yedam.java.ch0802;

public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}
	public void checkFare() {
		System.out.println("돈을 확인합니다.");
	}

}
