package com.yedam.java.ch0603;

public class ScoresManagement {
	
	// 전체 학생 총점
	public int getTotalScore(Student[] students) {
		int sum = 0;
		for(Student temp: students)
			sum += temp.getScore();
		return sum;
	}
	// 전체 학생 평균 
	public double getAverage(Student[] students) {
		StudentsManagement temp = StudentsManagement.getInstance();
		return getTotalScore(students)/temp.getTotalCount(); 
	}
}
