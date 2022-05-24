package com.yedam.example1;

public class Student {
	//	Field
	private String name;
	private int money;
	
	//	Constructor
	public Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	//	Method
	public void take(Subway subway) {
		int pay = subway.getPay();
		this.money -= pay;
		subway.take(pay);
	}
	public void take(Bus bus) {
		int pay = bus.getPay();
		this.money -= pay;
		bus.take(pay);
	}
	
	public void showInfo() {
		System.out.println(this.name + "님의 남은 돈은 " + this.money +"입니다.");
	}
}
