package com.yedam.java.ch1201;

import java.util.List;

public class Server {
	private List<User> User;
	
	public void login(User user) {
		User.add(user);
	}
	
}
