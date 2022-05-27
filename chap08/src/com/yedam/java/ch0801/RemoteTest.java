package com.yedam.java.ch0801;

public class RemoteTest {

	public static void main(String[] args) {
		Control rc = new TV();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(7);
		rc.searchInternet("URL URL");
		rc.executeApp("Naver");
		rc.plusService();
	}
}
