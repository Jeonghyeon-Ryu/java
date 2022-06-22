package com.yedam.app;

import com.yedam.app.common.LoginControl;

public class Main {

	public static void main(String[] args) {
		new LoginControl();
	}

}

// 익명 : 조회만
// 일반 : 조회, 입출고만 
// 관리자 : 전부
// 방식 2가지-> 권한에따라 실행 클래스 나누는것 / 