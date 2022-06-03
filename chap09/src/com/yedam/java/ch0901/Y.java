package com.yedam.java.ch0901;

public class Y {
	// 필드
	int field1;
	static int field2;
	
	// 메소드
	void method1() { System.out.println("Y Method1"); }
	static void method2() {System.out.println("Y Method2");}
	
	// 인스턴스 멤버 클래스
	class B {
		B() {
			field1 = 10;
			field2 = 20;
			method1();
			method2();
		}
		void method1() {
			field1 = 10;
			field2 = 20;
			method1();
			method2();
		}
	}
	static class C {
		C() {
//			field1 = 10;
			field2 = 20;
//			method1();
			method2();
		}
//		void method3() {
//			field1 = 10;
//			field2 = 20;
//			method1();
//			method2();
//		}
//		static void method4() {
//			field1 = 10;
//			field2 = 20;
//			method1();
//			method2();
//		}
	}
	int method(int arg) {		// 메소드 싲가할 때 arg와 var 둘다 상수(final)로 고정됨
		int var = 1;
//		arg = 50;
//		var = 100;
		class D {
			void method() {
				int result = arg+var;
			}
		}
		
		D d = new D();
		d.method();
		
		return var;
	}

}
