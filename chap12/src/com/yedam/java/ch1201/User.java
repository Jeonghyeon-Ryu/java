package com.yedam.java.ch1201;

public class User extends Thread{
	private Calculator cal;
	public static int serial = 0;
	
	public void setCalculator(Calculator cal) {
		serial +=100;
		this.setName("User " + serial);
		this.cal = cal;
	}
	
	@Override
	public synchronized void run() {
		System.out.println("Run Start");
		cal.setMemory(100 + serial);
	}
}
