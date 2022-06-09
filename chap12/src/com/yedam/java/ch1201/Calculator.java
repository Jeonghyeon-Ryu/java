package com.yedam.java.ch1201;

public class Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
		}
		Thread info = Thread.currentThread();
		System.out.println("현재 Thread : " + info.getName() + ", Memory : " + getMemory());
	}
}
