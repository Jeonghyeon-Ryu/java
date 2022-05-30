package com.yedam.java.ch0604;

import java.util.Scanner;

public class CalculateMain {

	public static void main(String[] args) {
		init();
	}
	public static void init() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------- 계산기 --------");
		System.out.print("계산식을 입력하세요(종료:exit) : ");
		String st = scanner.nextLine();
		Calculator cal = new Calculator();
		
		Calculator.process(st);
		scanner.close();
	}
}
