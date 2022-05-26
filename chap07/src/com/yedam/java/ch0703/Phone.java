package com.yedam.java.ch0703;

public abstract class Phone {
	public String model;
	public String color;
	
	//생성자
	public Phone(String model, String color) {
		this.model=model;
		this.color=color;
	}
	
	//메소드
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	public abstract void bell();
}
