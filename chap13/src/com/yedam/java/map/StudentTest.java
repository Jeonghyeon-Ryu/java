package com.yedam.java.map;

import java.util.HashMap;
import java.util.Map;

public class StudentTest {

	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		Student a = new Student(1,"류정현");
		Student b = new Student(1,"류정현");
		System.out.println("a hashCode : " + a.hashCode());
		System.out.println("b hashCode : " + b.hashCode());
		
		map.put(new Student(1,"류정현"), 99);
		map.put(new Student(2,"홍길동"), 80);
		map.put(new Student(1,"류정현"), 100);
		
		System.out.println("총 Entry 수 : " + map.size());
		
		System.out.println(map.get(new Student(1,"류정현")));
	}

}
