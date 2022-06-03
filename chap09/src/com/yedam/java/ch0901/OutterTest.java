package com.yedam.java.ch0901;

public class OutterTest {

	public static void main(String[] args) {
		Outter outter = new Outter();
		
		Outter.Inner inner = outter.new Inner();
		
		inner.print();
	}
}
