package com.yedam.java.ch0701;

public class DmbPhone extends Phone {
	//
	int ch;
	//
	public DmbPhone(String model, String color) {
		super(model, color);
		//	부모클래스의 디폴트 생성자가 여기서 먼저 호출된다.
//		this.model = model;
//		this.color = color;
//		this.ch = 10;
	}
	//
	void turnOnDmb() {
		System.out.println("채널 " + ch + "번 방송 수신을 시작합니다.");
	}
	void turnOffDmb() {
		System.out.println("방송 수신을 멈춥니다.");
	}
	void changeChannel(int ch) {
		this.ch = ch;
		System.out.println("채널 " + ch + "번으로 바꿉니다.");
	}
}
