package com.yedam.java.ch0605;

public class Singleton {
	// 1. 생성자를 막음(private)
	// 2. 필드에서 static 으로 클래스 생성 + 사용 막음(private) - 외부에서 못없애게
	// 3. 메소드로만 접근하도록 함. (public & static)
	// 필드
	private static Singleton singleton = new Singleton();
	private int n;
	// 생성자
	private Singleton() {
		n = 1;
	}
	// 메소드
	static Singleton getInstance() {
		return singleton;
	}
	void setN(int n) {
		this.n=n;
	}
	int getN() {
		return this.n;
	}
}
