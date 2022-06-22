package com.yedam.app.common;

import java.util.Scanner;

import com.yeddam.app.members.Member;
import com.yeddam.app.members.MembersDAO;

public class LoginControl {
	// 로그인 정보 저장
	private static Member loginInfo = null;
	public static Member getInstance() {
		return loginInfo;
	}
	private Scanner sc = new Scanner(System.in);
	
	public LoginControl() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo == 1) {			// 로그인
				login();
			} else if(menuNo == 2) {	// 종료
				exit();
				break;
			} else {
				showInputError();
			}
		}
	}
	
	private void menuPrint() {
		System.out.println("===============");
		System.out.println(" 1.로그인  2.종료 ");
		System.out.println("===============");
	}
	private int menuSelect() {
		int menuNo = 0;
		System.out.print(" 메뉴 선택 : ");
		try {
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("메뉴 숫자를 입력해주세요.");
		}
		return menuNo;
	}
	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}
	private void showInputError() {
		System.out.println("잘못된 메뉴를 선택하였습니다.");
	}
	private void login() {
		Member member = inputMember();
		loginInfo = MembersDAO.getInstance().selectOne(member);
		if(loginInfo==null) return;

		System.out.println("로그인 성공");
		new Management().run();
	}
	private Member inputMember() {
		Member member = new Member();
		System.out.print(" 아이디 : ");
		member.setMemberId(sc.nextLine());
		System.out.print(" 비밀번호 : ");
		member.setMemberPw(sc.nextLine());
		
		return member;
	}
}
