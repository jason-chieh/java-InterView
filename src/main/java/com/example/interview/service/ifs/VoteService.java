package com.example.interview.service.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.interview.entity.Title;
import com.example.interview.vo.BasicRes;
import com.example.interview.vo.TitleReq;
import com.example.interview.vo.UserReq;


public interface VoteService {

	//�s�W�벼�ﶵ
	public BasicRes create(TitleReq req);
	
	//�j�M�벼�ﶵ
	public List<Title>  search();
	
	//�벼
	public BasicRes vote(UserReq req);
	
	//�R���벼�ﶵ
	public BasicRes delete(TitleReq req);
}
