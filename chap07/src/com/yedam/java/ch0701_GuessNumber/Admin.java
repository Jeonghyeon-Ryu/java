package com.yedam.java.ch0701_GuessNumber;

import java.util.List;

public class Admin extends Observer {
	private List<User> Users; 
	private static String id = "admin";
	
	// 유저 # 요청식별자 # 아이디 # 변경사항 # 
	void getUsers() {
		this.msg = "0#1#" + Admin.id + "#" + "getUsers" + "#";
	}
	void getRank() {
		this.msg = "0#2#" + Admin.id + "#" + "getRank" + "#";
	}
	void blockUser(User user) {
		this.msg = "0#3#" + Admin.id + "#" + user.getId() + "#";
	}
}
