package com.yedam.java.ch1003;

public class BalanceInsufficientException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BalanceInsufficientException() {	}
	public BalanceInsufficientException(String message) {
		super(message);
	}
}
