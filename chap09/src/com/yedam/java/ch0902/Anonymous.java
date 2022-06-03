package com.yedam.java.ch0902;

public class Anonymous {
	// 필드
	Person field = new Person() {
		//필드
		String job = "회사원";
		//메소드
		void work() {
			System.out.println("출근합니다.");
		}
		@Override
		void wake() {
			System.out.println(job+"이 6시에 일어납니다.");
			work();
		}
	};
	
	// 생성자
	
	
	// 메소드
	void method1() {
		// 로컬 변수
		Person var = new Person() {
			//필드
			String job = "취준생";
			//메소드
			void walk() {
				System.out.println("면접봅니다.");
			}
			@Override
			void wake() {
				System.out.println(job + "이 7시에 일어납니다.");
				walk();
			}
		};
		
		var.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}
