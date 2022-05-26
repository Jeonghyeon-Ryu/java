package com.yedam.java.ch0703;

public class DmbPhone extends Phone {

	public DmbPhone(String model, String color) {
		super(model, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void powerOn() {
		super.powerOn();
		System.out.println("dmb 부팅 완료!");
	}
	public void showDmb() {
		System.out.println("dmb 작동 시작!");
	}
	@Override
	public void bell() {
		System.out.println("벨 벨 벨 링 링 링 울 린 다");
		System.out.println("추 상 메 소 드 벨 소 리 리 리 리 리 ");
	}
	
	

}
