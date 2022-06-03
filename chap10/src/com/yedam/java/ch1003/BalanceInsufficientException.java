package com.yedam.java.ch1003;

public class BalanceInsufficientException extends Exception{
	public BalanceInsufficientException() {	}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
