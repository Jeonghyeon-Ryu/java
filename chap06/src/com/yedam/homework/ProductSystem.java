package com.yedam.homework;

import java.util.Scanner;

public class ProductSystem {
	int index=-1;
	Product[] product;
//	public static void main(String[] args) {
//		
//		while(run) {
//			System.out.println("| 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료 |");
//			System.out.print("번호입력 > ");
//			switch(sc.nextInt()) {
//			case 1:
//				System.out.println("상품 수 입력 > ");
//				product = new Product[sc.nextInt()];
//				break;
//			case 2:
//				
//				break;
//			case 3:
//				break;
//			case 4:
//				break;
//			case 5:
//				break;
//			}
//		}
//	}
	public void setListSize(int n) {
		product = new Product[n];
	}
	public void putProduct(String name, int price) {
		Product tmp = new Product();
		tmp.setName(name);
		tmp.setPrice(price);
		product[++index] = tmp;
	}
	public void printList() {
		for(int i=0; i<=index; i++) {
			System.out.println(product[i].getName() + " : " + product[i].getPrice());
		}
	}
	public void analyzeProduct() {
		
	}
}
