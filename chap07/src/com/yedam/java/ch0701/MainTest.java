package com.yedam.java.ch0701;

public class MainTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Phone phone = new Phone("폴더폰", "빨강");
		DmbPhone dmbPhone = new DmbPhone("슬라이드폰", "파랑");
		
		System.out.println("모델 : " + dmbPhone.model);
		System.out.println("색상 : " + dmbPhone.color);
		System.out.println("채널 : " + dmbPhone.ch);
		
		dmbPhone.powerOn();
		dmbPhone.bell();
		dmbPhone.call();
		
	}

}
