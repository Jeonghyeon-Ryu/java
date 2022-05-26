package com.yedam.java.ch0702;

public class KumhoTire extends Tire {
	
	public KumhoTire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " KumhoTire 수명 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
			return false;
		}
	}
}
