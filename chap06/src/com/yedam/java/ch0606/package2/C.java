package com.yedam.java.ch0606.package2;

import com.yedam.java.ch0606.package1.A;

public class C extends A{

	A a1 = new A(true);
//	A a2 = new A(1);
//	A a3 = new A("문자열");
	
	public C() {
		A a = new A();
		
		a.field1 = 1;
//		a.field2 = 1; // 다른패키지에서 접근 막음 
//		a.field3 = 1;
		
		field2 =0;
//		field4 =0;
		a.method1();
//		a.method2();
//		a.method3();
	}
}
