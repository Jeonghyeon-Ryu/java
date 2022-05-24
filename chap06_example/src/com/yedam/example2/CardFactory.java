package com.yedam.example2;

public class CardFactory {
	//	필드 ( 싱글톤 )
	private static CardFactory instance = new CardFactory();
	//	생성자 ( 싱글톤 )
	private CardFactory() { }
	//	메소드
	public static CardFactory getInstance() {	// ( 싱글톤 ) 
		return instance;
	}
	
	public Card createCard() {
		return new Card();
	}
}