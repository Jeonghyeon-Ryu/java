package com.yedam.java.ch0701_GuessNumber;

public class User extends Observer {
	private String id;
	private String pw;
	private String name;
	private int[] score = new int[2];	// 0 : 패배 / 1 : 승리 
	
	//	생성자 - 회원가입
	protected User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.score[0] = 0;
		this.score[1] = 0;
	}
	
	//	메소드
	//	정보 확인
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	
	public void setPw(String pw) {
		this.msg = "11#" + this.id + "#" + pw + "#";
	}
	public void setName(String name) {
		this.msg = "12#" + this.id + "#" + name + "#";
	}
	public void getScore() {
		System.out.println("승 : " + score[1]);
		System.out.println("패 : " + score[0]);
		System.out.println("승률 : " + ((double)score[1]/score[0]*100));
	}
	public void withdrawal() {
		this.msg = "10#" + this.id + "#";
	}
}
