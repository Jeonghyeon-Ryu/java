package com.yedam.java.test;

public class Student {
	//	필드
	private int number;
	private String name;
	private int score;
	
	//	생성자
	public Student(int number, String name, int score) {
		this.number = number;
		this.name = name;
		this.score = score;
	}
	
	//	메소드
	public int getNumber() {
		return this.number;
	}
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	
}
