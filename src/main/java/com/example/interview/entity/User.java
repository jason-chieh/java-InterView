package com.example.interview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id ;
	
	@Column(name="name")
	private String name ;
	
	@Column(name="title_id")
	private int titleId ;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, int titleId) {
		super();
		this.id = id;
		this.name = name;
		this.titleId = titleId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTitleId() {
		return titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}
	
	
	

}
