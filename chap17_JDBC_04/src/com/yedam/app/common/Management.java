package com.yedam.app.common;

import java.util.Scanner;

import com.yedam.app.deal.ReceivingGoodsDAO;
import com.yedam.app.products.ProductDAO;
import com.yedam.app.products.ProductInfoManagement;

public class Management {
	//필드
	protected Scanner sc = new Scanner(System.in);
	protected ProductDAO pDAO = ProductDAO.getInstance();
	protected ReceivingGoodsDAO rDAO = ReceivingGoodsDAO.getInstance();
	protected TakeOutGoodsDAO tDAO = TakeOutGoods.getInstance();
	//생성자
	public void run() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			if(menuNo==1) {	//제품 정보관리
				new ProductInfoManagement();
			} else if (menuNo==2) {	//제품관리
				new ProductStockManagement();
			} else if (menuNo==9) {	//프로그램 종료
				exit();
				break;
			} else {	// 오류
				showInputError();
			}
		}
	}
	//메소드
	protected void menuPrint() {
		System.out.println("===============================");
		System.out.println(" 1.제품정보관리  2.제품재고관리  9.종료");
		System.out.println("===============================");
	}
	protected int menuSelect() {
		int menuNo = 0;
		try {
			System.out.println(" 메뉴 선택 > ");
			menuNo = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해주세요.");
		}
		return menuNo;
	}
	protected void exit() {
		System.out.println(this.getClass() + " 관리 시스템을 종료합니다.");
	}
	protected void showInputError() {
		System.out.println("잘못된 메뉴 선택을 하였습니다.");
	}
}
