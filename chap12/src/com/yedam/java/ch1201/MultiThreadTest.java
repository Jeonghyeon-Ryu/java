package com.yedam.java.ch1201;

public class MultiThreadTest {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName() + " 쓰레드 시작, 우선순위 : " + mainThread.getPriority());
		
		Runnable a = new ThreadA();
		Thread t = new Thread(a);
		t.setName("ThreadA");
		System.out.println(t.getName() + " 쓰레드 시작, 우선순위 : " + t.getPriority());
		t.start();
		
		Thread t2 = new ThreadB();
		System.out.println(t2.getName() + " 쓰레드 시작");
		t2.start();
		
		for(int i=0; i<6; i++) {
			System.out.println("메인 쓰레드 출력 : " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
