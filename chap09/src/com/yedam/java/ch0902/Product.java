package com.yedam.java.ch0902;

public class Product {
	//필드
	RemoteControl field = new RemoteControl() {
		String msg = "스마트TV";
		void print() {
			System.out.println("제품 종류 : " + msg);
		}
		@Override
		public void turnOn() {
			print();
			System.out.println(msg + "의 전원을 켭니다.");
		}

		@Override
		public void turnOff() {
			print();
			System.out.println(msg + "의 전원을 끕니다.");
		}
		
	};
	//생성자
	//메소드
	public RemoteControl method1() {
		int volumn = 30;
		RemoteControl var = new RemoteControl() {
			String msg = "오디오";
			void print() {
				System.out.println("제품 종류 : " + msg);
			}
			@Override
			public void turnOn() {
				print();
				System.out.println(msg + "의 전원을 켭니다.");
				System.out.println("현재 볼륨 : " + volumn);
			}

			@Override
			public void turnOff() {
				print();
				System.out.println(msg + "의 전원을 끕니다.");
			}
			
		};
		var.turnOn();
		var.turnOff();
		
		return var;
	}
	
	public void method2(RemoteControl remoteControl) {
		remoteControl.turnOn();
		remoteControl.turnOff();
	}
}
