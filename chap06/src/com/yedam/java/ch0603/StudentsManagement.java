package com.yedam.java.ch0603;

import java.util.ArrayList;
import java.util.List;
	//	싱글톤으로 구현 해보자
public class StudentsManagement {
	private static StudentsManagement instance = new StudentsManagement();
	private static int serialNumber=20200000;
	private List<Student> students;
	
	//	싱글톤 생성자
	private StudentsManagement() { 
		 students = new ArrayList<>();
	}
	//	메소드
	public static StudentsManagement getInstance() {
		return instance;
	}
	public Student inputStudent(String name) {
		StudentsManagement.serialNumber++;
		Student student = new Student(StudentsManagement.serialNumber,name);
		students.add(student);
		return student;
	}
	public void removeStudent(Student student) {
		students.remove(student);
	}
	public void infoStudent(Student student) {
		System.out.println(student.getName() + "의 학번 : " + student.getNumber());
		System.out.println(student.getName() + "의 성적 : " + student.getScore());
	}
	// 전체 학생수
	public int getTotalCount() {
		return students.size();
	}

}
