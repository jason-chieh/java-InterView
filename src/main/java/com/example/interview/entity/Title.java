package com.example.interview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="title")
public class Title {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="id")
	private int id ;
	
	@Column(name="vote_name")
	private  String voteName;
	
	@Column(name="vote_num")
	private  int voteNum;


	
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Title(int id, String voteName, int voteNum) {
		super();
		this.id = id;
		this.voteName = voteName;
		this.voteNum = voteNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoteName() {
		return voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}


	public int getVoteNum() {
		return voteNum;
	}

	public void setVoteNum(int voteNum) {
		this.voteNum = voteNum;
	}
	
	
	

}
