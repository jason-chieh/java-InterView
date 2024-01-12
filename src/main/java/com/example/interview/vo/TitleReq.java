package com.example.interview.vo;

import com.example.interview.entity.Title;

public class TitleReq {

	private Title title = new Title();

	public TitleReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TitleReq(Title title) {
		super();
		this.title = title;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	
}
