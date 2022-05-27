package com.yedam.java.ch0701_GuessNumber;

import java.io.IOException;
import java.util.Scanner;

public class Main extends Observer {
	// 필드
	static Main start = new Main();					//메인시작
	Scanner sc = new Scanner(System.in);
	
	// 메인
	public static void main(String[] args) throws IOException, InterruptedException {
		User mainUser = new User("MAIN","MAIN","MAIN");
		Server server = Server.getInstance();
		Runnable s = server;
		Thread tServer = new Thread(s);
		tServer.start();
		server.attach(mainUser);
		
		while(true) {
			start.menuPrint();
			int menuNo = start.menuSelect();
			if(menuNo==1) {
				start.login(mainUser);
			}else if (menuNo==2) {
				start.signUp();
			}else if (menuNo==3) {
				start.exit();
				tServer.interrupt();
				break;
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
		System.out.print("입력 > ");
		return Integer.parseInt(sc.nextLine());
	}
	private void login(User mainUser) throws InterruptedException {
		System.out.println("=============== 로그인 화면 ===============");
		String id = inputId();
		String pw = inputPw();
		mainUser.msg = "3#1#" + id + "#" + pw + "#";
		
		while(mainUser.data==null) {	
			System.out.println("서버로부터 데이터를 기다리고 있습니다.");
			Thread.sleep(1000);
		}
		if(mainUser.data.approval==true) {
			GameSystem gameStart = new GameSystem(mainUser.data.user);
			gameStart.init();
			gameStart.run();
		}
	}
	private void signUp() {
		System.out.println("=============== 회원가입 화면 ===============");
		String id = inputId();
		String pw = inputPw();
		System.out.print("이름 > ");
		String name = sc.nextLine();
		
		User user = new User(id,pw,name);
		Server server = Server.getInstance();
		server.createUser(user);
	}
	private String inputId() {						// 유저로 부터 아이디 입력
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		return id;
		
	}
	private String inputPw() {						// 유저로 부터 비밀번호 입력
		System.out.print("비밀번호 > ");
		String pw = sc.nextLine();
		return pw;
	}
	
	private void exit() {
		try {
			Server server = Server.getInstance();
			server.shutdown();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
