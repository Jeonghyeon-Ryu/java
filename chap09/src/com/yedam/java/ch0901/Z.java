package com.yedam.java.ch0901;

public class Z {
	// 필드 , 인스턴스 멤버 -> Z 클래스 인스턴스가 존재 하여야 사용가능
	B field1 = new B();	// Z 클래스 인스턴스가 존재하여야 사용가능
	C field2 = new C();	// Z 클래스 인스턴스가 존재하여야 사용가능
	
	// 메소드, 인스턴스 멤버 -> Z 클래스 인스턴스가 존재하여야 사용가능
	void method1() {
		B var1 = new B();	// Z 클래스 인스턴스가 존재하여야 사용가능
		C var2 = new C();	// Z 클래스 인스턴스가 존재하여야 사용가능
	}
	
	/*********************************************************************************/
//	static B field3 = new B();	// field3 : Z 클래스 인스턴스가 존재 하지 않아도 사용가능 / B클래스 : Z 클래스 인스턴스가 존재하여야 사용가능
	static C field4 = new C();	// field4 : Z 클래스 인스턴스가 존재 하지 않아도 사용가능 / C클래스 : Z 클래스 인스턴스가 존재 하지 않아도 사용가능
	
	static void method2() {	// Z 클래스 인스턴스가 존재 하지 않아도 사용가능
//		B var1 = new B();	// Z 클래스 인스턴스가 존재하여야 사용가능
		C var2 = new C();	// Z 클래스 인스턴스가 존재 하지 않아도 사용가능
	}
	
	/*********************************************************************************/
	// 인스턴스 멤버 클래스 -> Z 클래스 인스턴스가 존재하여야 사용가능
	class B{}
	// 정적 멤버 클래스 -> Z 클래스 인스턴스가 존재 하지 않아도 사용가능
	static class C{}
}
