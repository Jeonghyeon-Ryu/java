package com.yedam.java.ch0702;

public class ChildTest {
	public static void main(String[] args) {
		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();
		
		GranPa pa = new GranPa();
		pa.method();
		pa = father;
		father.method();
		pa = uncle;
		uncle.method();
		pa = child;
		child.method();
		pa=cousin;
		cousin.method();

		Father fa = child;
//		fa = uncle;
//		fa = cousin;
		fa.method();
		Uncle un = cousin;
//		un = father;
//		un = child;
		un.method();
	}
}
