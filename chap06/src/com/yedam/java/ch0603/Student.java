package com.yedam.java.ch0603;

public class Student {
	//	Field
	private int number;
	private String name;
	private int score;
	
	//	Constructor
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	//	Method
	public int getNumber() {
		return this.number;
	}
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
