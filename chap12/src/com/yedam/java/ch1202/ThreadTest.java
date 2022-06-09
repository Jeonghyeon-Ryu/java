package com.yedam.java.ch1202;

public class ThreadTest {
	public static void main(String[] args) {
//		ThreadA t = new ThreadA();
//		t.start();
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		t.setStop(true);
		
		System.out.println("-----------------------------");
		Thread sub = new Thread() {
			@Override
			public void run() {
				
				while(true) {
					if(Thread.interrupted()) {
						break;
					}
					System.out.println("실행 중");
				}
				System.out.println("자원정리");
				System.out.println("종료");
			}
		};
		
		sub.start();
		try {
			Thread.sleep(500);
		} catch (Exception e) {

		}
		sub.interrupt();
		System.out.println("interrupt!");
	}
}
