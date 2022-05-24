package com.yedam.homework;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		String s;
		ProductSystem ps = ProductSystem.getProductSystem();
		
		while(run) {
			System.out.println("| 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료 |");
			System.out.print("번호입력 > ");
			switch(Integer.parseInt(sc.nextLine())) {
			case 1:
				System.out.print("상품 수 입력 > ");
				ps.setListSize(Integer.parseInt(sc.nextLine()));
				break;
			case 2:
				System.out.print("상품 및 가격 입력(상품 가격) > ");
				s = sc.nextLine();
				ps.putProduct(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));
				break;
			case 3:
				ps.printList();
				break;
			case 4:
				ps.analyzeProduct();
				break;
			case 5:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		sc.close();
	}
}
