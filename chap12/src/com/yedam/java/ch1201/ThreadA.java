package com.yedam.java.ch1201;

public class ThreadA implements Runnable{
	
	public void run() {
		for(int i=0; i<6; i++) {
			System.out.println("쓰레드A 출력 : " + i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
