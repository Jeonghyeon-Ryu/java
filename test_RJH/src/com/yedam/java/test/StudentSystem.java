package com.yedam.java.test;

public class StudentSystem {
	private int index = -1;
	private Student[] studentList;
	
	public void setStudentListSize(int size) {
		studentList = new Student[size];
	}
	//	2. 학생정보 등록
	public void setStudentInfo(int index, int number, String name, int score) {
		if(index<studentList.length) {
			studentList[index] = new Student(number,name,score);
			this.index=index;
		}
	}
	//	3. 학생정보 전체 조회
	public void getStudentsInfo() {
		for(Student temp: studentList)
			System.out.println(temp.getNumber() + " 학번의 점수는 "+ temp.getScore()+"입니다.");
	}
	//	4-1 최고점수
	public Student getMaxScore() {
		Student maxStudent=studentList[0];
		for(int i=1; i<=index; i++) {
			if(maxStudent.getScore()<studentList[i].getScore())
				maxStudent=studentList[i];
		}
		return maxStudent;
	}
	//	4-2 최저점수
	public Student getMinScore() {
		Student minStudent=studentList[0];
		for(int i=1; i<=index; i++) {
			if(minStudent.getScore()>studentList[i].getScore())
				minStudent=studentList[i];
		}
		return minStudent;
	}
	//	4. 최고점,최저점을 제외한 평균점수
	public double getAverage() {
		double result=0;
		for(Student temp: studentList) {
			result += temp.getScore();
		}
		result = result - getMaxScore().getScore() - getMinScore().getScore();
		return result/(index-1);
	}
}
