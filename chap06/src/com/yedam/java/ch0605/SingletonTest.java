package com.yedam.java.ch0605;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		obj1.setN(2);
		obj2.setN(3);
		System.out.println(obj1.getN() + " " + obj2.getN());
		System.out.println(obj1==obj2);
	}

}
