package com.yedam.homework;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		boolean run = true;		// While 반복문 종료 확인위한 변수
		Scanner sc = new Scanner(System.in);	// 사용자로부터 번호 입력을 위한 변수
		String s;	// 상품 및 가격 입력을 받기위한 변수
		ProductSystem ps = ProductSystem.getProductSystem();	// ProductSystem 싱긅톤 인스턴스 획득
		
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
				s = sc.nextLine();	//	한줄로 입력받음  ( 예 : 사과 1000 )
				ps.putProduct(s.split(" ")[0], Integer.parseInt(s.split(" ")[1]));	// 공백으로 분리 ( 예 : 사과 / 1000 )
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
