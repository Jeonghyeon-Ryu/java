package com.yedam.java.ch0702;

public class HankookTire extends Tire {
	
	public HankookTire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	@Override
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " HankookTire 수명 : " + (maxRotation - accumulatedRotation));
			return true;
		} else {
			System.out.println("*** " + location + " HankookTire 펑크 ***");
			return false;
		}
	}

}
