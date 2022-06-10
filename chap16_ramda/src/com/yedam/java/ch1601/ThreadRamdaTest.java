package com.yedam.java.ch1601;

public class ThreadRamdaTest {

	public static void main(String[] args) {
		
		Runnable rn = () -> {
			System.out.println("람다식 Thread");
			for(int i=0; i<5; i++) {
				System.out.println(i);
			}
		};
		
		Thread t = new Thread(rn);
		t.start();
		
		// Thread 생성자 매개변수에서 바로 람다식으로 run 함수 구현
		Thread t2 = new Thread(()->{
			System.out.println("매개변수 람다식 Thread");
			for(int i=0; i<5; i++) {
				System.out.println(i);
			}
		});
		t2.start();
	}

}
