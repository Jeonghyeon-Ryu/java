package com.yedam.java.ch1601;

public class RamdaTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MyFunInterfaceA fia = () -> System.out.println("Functional Interface A");
		MyFunInterfaceB fib = x -> System.out.println("Functional Interface B : " + x);
		MyFunInterfaceC fic = (x,y) -> { System.out.println("Functional Interface C : " + (x+y)); return x+y;};
		
		fia.method();
		fib.method(5);
		int result = fic.method(3, 4);
		
		System.out.println("result : " + result);
		
		int val1 = 10;
		int val2 = 20;
		
//		val1 이 Final 변수로 인식됨 
//		fic = (x,y) -> {val1=20; return val1+val2; };
	}
}
