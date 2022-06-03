package com.yedam.java.ch0902;

public class ano extends Person{
	String a = "회사원";
	
	void work() {
		System.out.println("일 시작");
	}
	@Override
	void wake() {
		System.out.println("일어남");
		work();
	}
}
