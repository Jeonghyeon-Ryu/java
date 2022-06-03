package com.yedam.java.ch1101;

public class ObjectTest {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		obj1 = new String("10");
		obj2 = new String("10");
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1 과 obj2가 논리적으로 동등합니다.");
		}
		
		if(obj1 == obj2) {
			System.out.println("obj1 과 obj2가 물리적으로 동등합니다");
		}
		
		Member m1 = new Member("blue");
		Member m2 = new Member("blue");
		Member m3 = new Member("red");
		
		if(m1.hashCode()==m2.hashCode()) {
			System.out.println("m1 해쉬 m2 해쉬 동일");
		}
		
		if(m1.equals(m2)) {
			System.out.println("m1과 m2는 동일합니다.");
		} else {
			System.out.println("m1과 m2는 다릅니다.");
		}
		
		if(m1.equals(m3)) {
			System.out.println("m1과 m3는 동일합니다.");
		} else {
			System.out.println("m1과 m3는 다릅니다.");
		}
			
	}
}
