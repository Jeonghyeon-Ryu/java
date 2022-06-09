package com.yedam.java.ch1202;

public class PrintThread extends Thread {
	@Override
	public void run() {
		
		// Interrupt - > 종료할 경우.
		try {
			while(true) {
				System.out.println("실행중");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("자원정리");
		System.out.println("종료");
	}
}
