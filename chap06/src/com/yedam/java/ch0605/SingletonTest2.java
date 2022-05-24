package com.yedam.java.ch0605;

public class SingletonTest2 {

	public static void main(String[] args) {
		Singleton single = Singleton.getInstance();
		System.out.println(single==null);
	}

}
