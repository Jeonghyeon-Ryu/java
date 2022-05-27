package com.yedam.java.ch0702;

public class Father implements GranPa {
	public static final int MAX = 20;
	@Override
	public void method() {
		System.out.println("Father Method");
		System.out.println(MAX);
		System.out.println(GranPa.MAX);
	}
	
	void method2() {
		System.out.println("Father's Original Method");
	}
}
