package com.yedam.java.ch0702;

public class ChildTest2 {

	public static void main(String[] args) {
		GranPa pa = new Father();
		GranPa pa2 = new Uncle();
		GranPa pa3 = new Child();
		
		pa.method();
		pa2.method();
		pa3.method();
		
		Father fa = null;
		if( pa instanceof Father ) {
			fa = (Father)pa;
			fa.method();
			fa.method2();
		}
		
		pa = new Uncle();
		if( pa instanceof Father ) {
			fa = (Father)pa;
			fa.method();
			fa.method2();
		}else
			System.out.println("pa는 Father 인스턴스가 아니다");
		System.out.println(pa.getClass());
		
	}
}
