package com.yedam.java.ch1501;

public class MethodTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		BoxA<Integer> intBox = Util.<Integer>boxing(100);
		
		Pair<Integer, String> p1 = new Pair<>(1,"사과");
		Pair<Integer, String> p2 = new Pair<>(1,"사과");
		
		boolean result1 = Util.compare(p1, p2);
		if(result1) {
			System.out.println("논리적으로 동등한 객체");
		} else {
			System.out.println("논리적으로 다른 객체");
		}
		
		Util.<String,Integer>printInfo("홍길동");
			
	}
	

}
