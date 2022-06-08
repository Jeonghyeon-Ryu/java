package com.yedam.java.test;

import java.util.Scanner;

public class Main {

	/* 
	 * 1. 전월 실적입력
	 * 2. 전월 실적으로 Member 생성 -> getMemberShip -> Gold/Silver
	 * 3. 생성된 Member 등급으로 Card 생성 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("전월실적 >>");
		int record = sc.nextInt();
		
		Member member = Member.getMemberShip(record);
		member.showMemberInfo();
		
		Payment myCard = null;
		if(member instanceof Gold) {
			myCard = new VIPCard();
		}else if(member instanceof Silver) {
			myCard = new GreenCard();
		}
		System.out.println("=== 등급에 따른 카드 사용시 결제 예상금액 ===");
		System.out.println("사용할 금액 >>");
		int price = sc.nextInt();
		System.out.println("결제방법 : 1.오프라인, 2.온라인, 3.간편결제");
		int pay= sc.nextInt();
		
		int result = 0;
		switch(pay) {
		case 1:
			result = myCard.offline(price);
			break;
		case 2:
			result = myCard.online(price);
			break;
		case 3:
			result = myCard.simple(price);
			break;
		}
		
		System.out.println("결제 예상 금액 : " + result);
		myCard.showCardInfo();
		sc.close();
	}

}
