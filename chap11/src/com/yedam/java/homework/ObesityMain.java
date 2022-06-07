package com.yedam.java.homework;

public class ObesityMain {

	public static void main(String[] args) {
		Human hong = new StandardWeightInfo("홍길동",168,45);
		Human park = new ObesityInfo("박둘이",168,90);
		
		hong.getInformation();
		park.getInformation();
	}
}
