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
	public int getScore(int number) {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
