package com.yedam.java.ch0703;

public class PhoneTest {

	public static void main(String[] args) {
//		Phone p = new Phone("Z플립", "블랙");
//		p.powerOn();
		DmbPhone dmb = new DmbPhone("Z폴드", "노랑");
		dmb.powerOn();
		
		dmb.showDmb();
		dmb.bell();
		
	}

}
