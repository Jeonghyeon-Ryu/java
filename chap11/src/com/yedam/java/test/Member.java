package com.yedam.java.test;

public abstract class Member {
	static int GRADE_STANDARD = 1000000;
	int record;
	String grade;
	
	public Member(int record) {
		this.record = record;
	}
	
	public void showMemberInfo() {
		System.out.println("현재 실적은 " + record + "이며 회원등급은 " + grade + "입니다.");
	}
	
	public static Member getMemberShip(int record) {
		Member member;
		if(record>=GRADE_STANDARD) {
			member = new Gold(record);
		}else {
			member = new Silver(record);
		}
		return member;
	}
}
