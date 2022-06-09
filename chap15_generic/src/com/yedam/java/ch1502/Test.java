package com.yedam.java.ch1502;

public class Test {
	public static void main(String[] args) {
		testInterface a = new testInterface() {
			public int getInt(int x) {
				return x;
			}
		};
		
		testInterface b = x -> x;
		
		System.out.println(b.getInt(5));
	}

}
