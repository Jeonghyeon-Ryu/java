package com.yedam.java.ch0701_GuessNumber;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	// 필드
	Scanner sc = new Scanner(System.in);
	
	// 메인
	public static void main(String[] args) throws IOException {
		Main start = new Main();
		
		GameSystem gameStart = new GameSystem();
		
		
		gameStart.init();
		
		Runnable m = gameStart;
		Runnable s = server;
		Thread tmain = new Thread(m);
		Thread tserver = new Thread(s);
		tmain.run();
		tserver.run();
		
		while(true) {
			start.menuPrint();
			int menuNo = start.menuSelect();
			if(menuNo==1) {
				start.login();
			}else if (menuNo==2) {
				start.signUp();
			}else if (menuNo==3) {
				start.exit();
			}
		}
	}
	
	//메소드
	private void menuPrint() {
		System.out.println("=============== 메인 화면 ===============");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 종료");
		System.out.println("=======================================");
	}
	private int menuSelect() {
		System.out.println("입력 > ");
		return Integer.parseInt(sc.nextLine());
	}
	private void login() {
		System.out.println("=============== 로그인 화면 ===============");
		System.out.println(" ID > ");
		String id = sc.nextLine();
		System.out.println(" PW > ");
		String pw = sc.nextLine();
	}
	private void signUp() {
		System.out.println("=============== 회원가입 화면 ===============");
		System.out.println("아이디 > ");
		String id = sc.nextLine();
		System.out.println("비밀번호 > ");
		String pw = sc.nextLine();
		System.out.println("이름 > ");
		String name = sc.nextLine();
		
		User user = new User(id,pw,name);
		server.
	}
}
