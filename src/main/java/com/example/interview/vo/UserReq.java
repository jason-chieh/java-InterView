package com.example.interview.vo;

import com.example.interview.entity.User;

public class UserReq {

	
	private User user = new User();

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserReq(User user) {
		super();
		this.user = user;
	}
	
	
}
