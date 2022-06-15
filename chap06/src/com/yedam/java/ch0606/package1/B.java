package com.yedam.java.ch0606.package1;

public class B extends A{
	A a1 = new A(true);
	A a2 = new A(1);		// protected??
//	A a3 = new A("문자열");
	
	public B() {
		A a = new A();
		
		a.field1 = 1;
		a.field2 = 1;
//		a.field3 = 1;
		field4 = 0;
		
		a.method1();
		a.method2();
//		a.method3();
	}
	
	@SuppressWarnings("unused")
	private void method1(int a) {
		a = 10;
	}
//	private void method2() {} // 오버라이딩 접근제한자 좁게 안됨
	
}
