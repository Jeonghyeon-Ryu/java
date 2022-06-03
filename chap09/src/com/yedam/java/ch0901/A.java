package com.yedam.java.ch0901;

public class A {
	static int field2;
	A() {
		System.out.println("A 인스턴스가 생성됨");
	}
	void method() {
		class D {
			//	필드
			int field1;
			//	생성자
			D() {
				System.out.println("D 인스턴스가 생성됨");
			}
			//	메소드
			void method1() {
				System.out.println("A클래스 > Method > D클래스 > Method1");
			}
		}
		
		D d = new D();
		d.field1 = 10;
		d.method1();
	}
	
	//	인스턴스 멤버 클래스
	class B{
		//	필드
		int field1;
//		static int field2;
		//	생성자
		B() {
			field1 = 10;
			System.out.println("B 인스턴스가 생성됨");
		}
		//	메소드
		void method1() {
			System.out.println("A클래스 내부 B클래스의 Method1");
		}
//		static void method2() {}
	}
	static class C {
		int field1;
		static int field2;
		C() {
			System.out.println("C인스턴스가 생성됨");
		}
		void method1() {
			System.out.println("A클래스 내부 정적 C클래스의 Method1");
		}
		static void method2() {
			System.out.println("A클래스 내부 정적 C클래스의 정적 Method2");
		}
	}
}
