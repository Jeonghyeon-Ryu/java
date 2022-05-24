package com.yedam.example2;

public class Card {
	//	필드
	private static int serialNum = 1100;
	private int cardId;
	
	//	생성자
	public Card() {
		this.cardId = ++Card.serialNum;
	}
	
	//	메소드
	public static int getSerialNum() {
		return serialNum;
	}
	public int getCardId() {
		return cardId;
	}
}

