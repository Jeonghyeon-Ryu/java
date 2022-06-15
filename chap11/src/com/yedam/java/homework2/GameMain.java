package com.yedam.java.homework2;

import java.util.Scanner;

public class GameMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println();
			System.out.println("2.문제2 | 3.문제3 | 아무버튼입력. 종료 ");
			System.out.print("선택하세요 >> ");
			switch(sc.nextLine()) {
			case "2":
				Q2Program q2 = new Q2Program();
				continue;
			case "3":
				Q3Program q3 = new Q3Program();
				continue;
			default :
				System.out.println("종료.");
				run=false;
			}	
		}
		sc.close();
	}
}
