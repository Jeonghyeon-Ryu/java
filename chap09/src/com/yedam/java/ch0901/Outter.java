package com.yedam.java.ch0901;

public class Outter {
	String field = "바깥클래스 - 필드";
	void method() {
		System.out.println("바깥클래스 - 메소드");
	}
	void methodA() {
		System.out.println("바깥클래스 - 메소드A");
	}
	
	class Inner {
		String field = "중첩클래스 - 필드";
		void method() {
			System.out.println("중첩클래스 - 메소드");
		}
		void print() {
			System.out.println(field);	// 내부 클래스의 필드 호출  ->  this만 적어도 됨.
			method();					// 내부 클래스의 메소드 호출 -> this만 적어도 됨.
			System.out.println();
			methodA();
			System.out.println();
			System.out.println(Outter.this.field);	// 바깥클래스의 필드를 내부클래스에서 호출하는 방법
			Outter.this.method();					// 바깥클래스의 메소드를 내부클래스에서 호출하는 방법
		}
	}
	
	interface I {
		int FIELD = 100;
		void method();
	}
	
	static interface N {
		int FIELD = 100;
		void method();
	}
}
