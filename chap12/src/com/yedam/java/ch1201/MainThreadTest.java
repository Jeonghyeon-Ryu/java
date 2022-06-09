package com.yedam.java.ch1201;

public class MainThreadTest {
	public static void main(String[] args) {
		for(int i=0; i<6; i++) {
			System.out.println(i + "번째 출력" );
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
