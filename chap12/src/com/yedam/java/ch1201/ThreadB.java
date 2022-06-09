package com.yedam.java.ch1201;

public class ThreadB extends Thread{
	@Override
	public void run() {
		for(int i=0; i<6; i++) {
			System.out.println("쓰레드B 출력 : " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
