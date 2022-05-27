package com.yedam.java.ch0701_GuessNumber;

public class User extends Observer {
	private String id;
	private String pw;
	private String name;
	private static int serialNumber = -1;
	private int number;
	private int[] score = new int[2];	// 0 : 패배 / 1 : 승리 
	
	//	생성자 - 회원가입
	protected User(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.number = ++User.serialNumber;
		this.score[0] = 0;
		this.score[1] = 0;
	}
	protected User(String id, String pw, String name,int number, int loose, int win) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.number = number;
		this.score[0] = loose;
		this.score[1] = win;
	}
	
	//	메소드
	
	//	정보 확인
	public String getId() {
		return this.id;
	}
	public String getPw() {
		return this.pw;
	}
	public String getName() {
		return this.name;
	}
	public int getNumber() {
		return this.number;
	}
	// 유저 # 요청식별자 # 아이디 # 변경사항 # 
	public void setPw(String pw) {
		this.msg = "1#1#" + this.number + "#" + pw + "#";
	}
	public void setName(String name) {
		this.msg = "1#2#" + this.number + "#" + name + "#";
	}
	public int[] getScore() {
		return this.score;
	}
	public void withdrawal() {
		this.msg = "1#0#" + this.number + "#";
	}
	
}
