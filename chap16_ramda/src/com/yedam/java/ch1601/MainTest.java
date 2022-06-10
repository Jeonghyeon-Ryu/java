package com.yedam.java.ch1601;

public class MainTest {

	public static void main(String[] args) {
		MyFunctionalInterface f1 = (x) -> { System.out.println("f1 : " + x); };
		MyFunctionalInterface f2 = new MyFunctionalInterface() {
			@Override
			public void method(int x) {
				System.out.println("f2 : " + x);
			}
		};
		
		f1.method(55);
		f2.method(30);
		
	}

}
