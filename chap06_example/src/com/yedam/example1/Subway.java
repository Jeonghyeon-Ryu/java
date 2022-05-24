package com.yedam.example1;

public class Subway {
	//	Field
	private String lineNumber;
	private int money;
	private int passengerCount;
	private int pay;
	//	Constructor
	
	public Subway(String lineNumber, int pay) {
		this.lineNumber = lineNumber;
		this.pay = pay;
	}
	//	Method
	public int getPay() {
		return this.pay;
	}
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	public void showInfo() {
		System.out.println(this.lineNumber+"의 승객은 "+this.passengerCount+"명 이고, 수입금은 "
				+ this.money + "원 입니다.");
	}
}
