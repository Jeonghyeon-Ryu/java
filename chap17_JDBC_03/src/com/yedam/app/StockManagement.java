package com.yedam.app;
import java.util.List;
import java.util.Scanner;

import com.yedam.java.product.Product;
import com.yedam.java.product.ProductDAO;

public class StockManagement {
	private ProductDAO productDAO = ProductDAO.getInstance();
	private Scanner sc = new Scanner(System.in);
	
	public StockManagement() {
		while(true) {
			//메뉴출력
			menuPrint();
			//메뉴입력
			int menuNo = selectMenu();
			//각 기능별 실행
			if(menuNo==1) {
				
			} else if(menuNo==2) {
				
			} else if(menuNo==3) {
				
			} else if(menuNo==4) {
				
			} else if(menuNo==5) {
				List<Product> list = productDAO.selectAll();
				list.forEach(x -> System.out.println(x));
			} else if(menuNo==9) {
				exit();
			} else {
				inputError();
			}
		}
	}
	private void menuPrint() {
		System.out.println("================================================");
		System.out.println(" 1.제품등록  2.입고  3.출고  4.제품재고  5.전체재고  9.종료");
		System.out.println("================================================");
	}
	private int selectMenu() {
		System.out.print("메뉴 선택 > ");
		return Integer.parseInt(sc.nextLine());
	}
	private void exit() {
		System.out.println("재고관리 시스템을 종료합니다.");
	}
	private void inputError() {
		System.out.println("메뉴선택이 잘못되었습니다.");
	}
}
