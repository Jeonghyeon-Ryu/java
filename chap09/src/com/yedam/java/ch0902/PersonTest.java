package com.yedam.java.ch0902;

public class PersonTest {

	public static void main(String[] args) {
		Anonymous ano = new Anonymous();
		
		// 익명객체 = 필드
		ano.field.wake();
		System.out.println();
		// 익명객체 = 로컬변수
		ano.method1();
		System.out.println();
		// 익명객체 = 매개변수
		ano.method2(new Person() {
			String job = "학생";
			void study() {
				System.out.println("공부합니다");
			}
			@Override
			void wake() {
				System.out.println(job+"이 9시에 일어납니다.");
				study();
			}
		});
	}

}
