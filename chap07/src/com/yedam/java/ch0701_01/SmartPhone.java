package com.yedam.java.ch0701_01;

import com.yedam.java.ch0701.Phone;

public class SmartPhone extends Phone {
	public SmartPhone(String model, String color) {
		super(model, color);
	}
	//	private Method
//	@Override
//	void print() {
//		
//	}
	//	final Method 
//	@Override
//	void powerOff() {
//		System.out.println("꺼진다아아아");
//		super.powerOff();
//		super.print();
//	}
	@Override
	protected void bell() {
		super.bell();
		System.out.println("벨소리 : 싸이 - that that!");
	}

//	@Override
//	void call() {
//		super.call();
//		System.out.println("안내문구 : 전화는 용건만 간단히 하자아아아");
//	}
	
}
