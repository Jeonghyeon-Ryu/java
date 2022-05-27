package com.yedam.java.ch0801;

public interface RemoteControl {
	// 상수 필드
	public static final int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	// 추상 메소드
	public abstract void turnOn();
	public abstract void turnOff();
	public abstract void setVolume(int volume);
	
	// 일반 메소드
	public default void setState(boolean state) {
		if(state) {
			System.out.println("정상");
		} else {
			System.out.println("비정상");
		}
	}
	
	// 정적 메소드
	public static void show() {
		System.out.println("추가된 메소드");
	}
	
}
