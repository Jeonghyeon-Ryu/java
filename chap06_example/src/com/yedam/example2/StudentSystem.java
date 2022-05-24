package com.yedam.example2;

public class StudentSystem {

	public static void main(String[] args) {
		Student s1 = new Student("류정현");
		System.out.println(Student.getSerialNum());
		System.out.println(s1.getName() + "의 학번 : "+ s1.getStudentId());
		
		Student s2 = new Student("가나다");
		System.out.println(Student.getSerialNum());
		System.out.println(s2.getName() + "의 학번 : "+ s2.getStudentId());
		
		System.out.println(s1.getName() + "의 학번 : "+ s1.getStudentId());
	}
}
