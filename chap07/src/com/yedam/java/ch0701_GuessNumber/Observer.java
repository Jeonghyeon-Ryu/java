package com.yedam.java.ch0701_GuessNumber;

public class Observer {
	protected String msg;
	
	protected void receive(String msg){
		System.out.println(this.msg + "에서 메시지를 받음 : " + msg);
    }
	protected String post() {
		return msg;
	}
}
