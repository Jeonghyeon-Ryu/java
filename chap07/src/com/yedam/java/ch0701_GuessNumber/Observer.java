package com.yedam.java.ch0701_GuessNumber;

public class Observer {
	protected String msg = "";
	protected Data data;
	
	protected void receive(Data data){
		this.data = data;
    }
	protected String post() {
		return msg;
	}
}

