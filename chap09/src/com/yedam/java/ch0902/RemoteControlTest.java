package com.yedam.java.ch0902;

public class RemoteControlTest {

	public static void main(String[] args) {
		Product product = new Product();
		
		// 구현객체 필드에 생성
		product.field.turnOn();
		product.field.turnOff();
		System.out.println();
		
		// 구현객체 메소드에 생성
		product.method1();
		System.out.println();
		
		// 구현객체 매개변수로 생성
		product.method2(new RemoteControl() {
			String msg = "노트북";
			void print() {
				System.out.println("제품 종류 : " + msg);
			}
			@Override
			public void turnOn() {
				print();
				System.out.println(msg + "의 전원을 켭니다.");
			}

			@Override
			public void turnOff() {
				print();
				System.out.println(msg + "의 전원을 끕니다.");
			}
			
		});
	}

}
