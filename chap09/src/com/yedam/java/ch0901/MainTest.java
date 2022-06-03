package com.yedam.java.ch0901;

public class MainTest {

	public static void main(String[] args) {
		
		// 인스턴스 멤버 클래스
		A a = new A();
		A.B b = a.new B();
		b.field1 = 7;
		System.out.println(b.field1);
		b.method1();
		
		System.out.println();
		
		// 정적 멤버 클래스
		A.C c = new A.C();
		c.method1();
		
		System.out.println();
		
		// 정적 멤버 클래스(A.C) VS 같은 이름의 클래스(C) -> 구분 됨.
		A.C.field2 = 10;
		C.field2=50;
		System.out.println(C.field2);	// 같은 이름 클래스의 field2
		A.C.method2();					// 정적 멤버 클래스의 Method2
		C c1 = new C();
		c1.method2();					// 같은 이름 클래스의 Method2
		
		System.out.println();
		
		// 메소드 로컬 클래스
		a.method();
	}
}
