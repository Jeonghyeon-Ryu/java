package com.yedam.java.emp;

import java.util.Scanner;

public class HRSystem {
	private Scanner sc = new Scanner(System.in);
	
	public HRSystem() {
		while(true) {
			// 메뉴 출력
			menuPrint();
			// 1. 접속 테이블 선택
			int menuNo = selectMenu();
			if(menuNo == 1) {
				new EmpSystem();
			}else if(menuNo == 2) {
				new DeptSystem();
			}else if(menuNo == 3) {
				new LocSystem();
			}else if(menuNo == 9) {
				exit();
				break;
			}else {
				inputError();
			}
		}
	}

	private void menuPrint() {
		System.out.println("======================================");
		System.out.println(" 1.사원테이블  2.부서테이블  3.지역테이블  9.종료");
		System.out.println("======================================");
	}
	private int selectMenu() {
		System.out.print("메뉴 선택 > ");
		return Integer.parseInt(sc.nextLine());
	}
	
	private void exit() {
		System.out.println("HR 시스템을 종료합니다.");
	}
	private void inputError() {
		System.out.println("메뉴 선택이 잘못되었습니다.");
	}
}
