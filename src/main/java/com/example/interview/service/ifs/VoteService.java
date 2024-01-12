package com.example.interview.service.ifs;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.interview.entity.Title;
import com.example.interview.vo.BasicRes;
import com.example.interview.vo.TitleReq;
import com.example.interview.vo.UserReq;


public interface VoteService {

	//新增投票選項
	public BasicRes create(TitleReq req);
	
	//搜尋投票選項
	public List<Title>  search();
	
	//投票
	public BasicRes vote(UserReq req);
	
	//刪除投票選項
	public BasicRes delete(TitleReq req);
}
