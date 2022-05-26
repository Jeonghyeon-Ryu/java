package com.yedam.java.example1;

import java.util.Scanner;

public class CustomerSystem {
	//	필드
	private Repo repo = new Repo();
	private Scanner sc = new Scanner(System.in);
	
	//	생성자
	public CustomerSystem() {
		while(true) {
			//메뉴출력
			menuPrint();
			//메뉴선택
			int menuNo = menuSelect();

			if(menuNo == 1) {
			//메뉴1 - 회원가입
				signUp();
			} else if(menuNo == 2) {
			//메뉴2 - 회원정보
				myPage();
			} else if(menuNo == 3) {
			//메뉴3 - 결제시 금액
				payInfo();
			} else if(menuNo == 5) {
			//메뉴4 종료
				exit();
				break;
			}
		}
	}
	public void menuPrint() {
		System.out.println("====================================");
		System.out.println("1.회원가입 | 2.회원정보 | 3.결제금액 | 4.종료");
		System.out.println("====================================");
	}
	public int menuSelect() {
		System.out.print("메뉴 > ");
		return Integer.parseInt(sc.nextLine());
	}
	void signUp() {
		// 등급선택
		// 회원 정보 입력
		Customer info = inputAll();
		// 가입
		repo.insert(info);
	}
	Customer inputAll() {
		int selected = selectGrade();
		System.out.println("아이디 > ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("이름 > ");
		String name = sc.nextLine();
				
		Customer customer = null;
		switch(selected) {
		case 1:
			customer = new Customer(id,name);
			break;
		case 2:
			customer = new Gold(id,name);
			break;
		case 3:
			customer = new Vip(id,name,"매니저");
			break;
		}
		return customer;
	}
	void myPage() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		System.out.println(info.showInfo());
	}
	void payInfo() {
		int customerId = inputOne();
		Customer info = repo.selectOne(customerId);
		System.out.print("구매 금액 > ");
		int price = Integer.parseInt(sc.nextLine());
		int pay = info.calcPrice(price);
		System.out.println("결제 금액 > " + pay);
	}
	void exit() {
		System.out.println("프로그램 종료");
	}
	int inputOne() {
		System.out.println("고객 아이디 > ");
		return Integer.parseInt(sc.nextLine());
	}
	int selectGrade() {
		System.out.println("1.SILVER | 2.GOLD | 3.VIP");
		System.out.println("=========================");
		return Integer.parseInt(sc.nextLine());
	}
}
