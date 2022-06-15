package com.yedam.java.ch0606.package1;

public class A {

	A a1 = new A(true);
	A a2 = new A(1);
	A a3 = new A("문자열");
	
	public A(boolean b) {}
	A(int b) {}
	private A(String s) {}

	/////////////////////////////////
	
	public int field1;
	protected int field2;
	@SuppressWarnings("unused")
	private int field3;
	int field4;
	
	//생성자
	public A() {
		field1 = 1;
		field2 = 1;
		field3 = 1;
		field4 = 1;
		
		method1();
		method2();
		method3();
	}
	
	public void method1() {}
	protected void method2() {}
	private void method3() {}


}