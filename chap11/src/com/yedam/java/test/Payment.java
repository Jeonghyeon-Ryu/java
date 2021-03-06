package com.yedam.java.test;

public interface Payment {
	static final double OFFLINE_PAYMENT_RATIO = 0.01;
	double ONLINE_PAYMENT_RATIO = 0.03;
	double SIMPLE_PAYMENT_RATIO = 0.05;
	
	int offline(int price);
	public int online(int price);
	public int simple(int price);
	public void showCardInfo();
}
