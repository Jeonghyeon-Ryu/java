package com.yedam.java.test;

public class VIPCard implements Payment {

	private String name;
	private String grade;
	private double saleRatio;
	private int point;
	private double pointRatio;
	
	public VIPCard() {
		name = "VIPCard";
		grade = "GOLD";
		saleRatio = 0.1;
		point = 0;
		pointRatio = 0.03;
	}
	
	@Override
	public int offline(int price) {
		point = (int)(price*pointRatio);
		int resultPrice = (int)(price - price*(saleRatio + 0.01));
		return resultPrice;
	}

	@Override
	public int online(int price) {
		point = (int)(price*pointRatio);
		int resultPrice = (int)(price - price*(saleRatio + 0.03));
		return resultPrice;
	}

	@Override
	public int simple(int price) {
		point = (int)(price*pointRatio);
		return (int)(price - price*(saleRatio + SIMPLE_PAYMENT_RATIO));
	}

	@Override
	public void showCardInfo() {
		System.out.println("카드명 : " + name);
		System.out.println("적용등급 : " + grade);
		System.out.println("할인율 : " + saleRatio);
		System.out.println("포인트 적립율 : " + pointRatio);
		System.out.println("적립 포인트 : " + point);
	}

}
