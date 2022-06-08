package com.yedam.java.test;

public class GreenCard implements Payment {
	private String name;
	private String grade;
	private int point;
	private double pointRatio;

	public GreenCard() {
		name = "GreenCard";
		grade = "SILVER";
		point = 0;
		pointRatio = 0.05;
	}
	
	@Override
	public int offline(int price) {
		point = (int)(price*pointRatio);
		int resultPrice = (int)(price - (price*0.01));
		return resultPrice;
	}

	@Override
	public int online(int price) {
		point = (int)(price*pointRatio);
		int resultPrice = (int)(price - (price*0.03));
		return resultPrice;
	}

	@Override
	public int simple(int price) {
		point = (int)(price*pointRatio);
		int resultPrice = (int)(price - (price*0.05));
		return resultPrice;
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드명 : " + name);
		System.out.println("적용등급 : " + grade);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 : " + point);
	}

}
