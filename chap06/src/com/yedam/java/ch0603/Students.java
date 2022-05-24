package com.yedam.java.ch0603;

import java.util.ArrayList;
import java.util.List;
	//	싱글톤으로 구현 해보자
public class Students {
	private static Students instance = new Students();
	private static int serialNumber=20200000;
	private List<Student> students;
	private int totalScore;
	
	//	싱글톤 생성자
	private Students() { 
		 students = new ArrayList<>();
	}
	//	메소드
	public static Students getInstance() {
		return instance;
	}
	public Student inputStudent(String name) {
		Students.serialNumber++;
		Student student = new Student(Students.serialNumber,name);
		students.add(student);
		return student;
	}
	// 전체 학생수
	public int getTotalCount() {
		return students.size();
	}
	// 전체 학생 총점
	public int getTotalScore() {
		int sum = 0;
		for(int i=0; i<students.size(); i++)
			sum += students.get(i).getScore(sum);
		this.totalScore=sum;
		return this.totalScore;
	}
	// 전체 학생 평균 
	public double getAverage() {
		return getTotalScore()/getTotalCount(); 
	}
}
