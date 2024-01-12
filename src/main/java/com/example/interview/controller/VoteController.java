package com.example.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.interview.entity.Title;
import com.example.interview.service.ifs.VoteService;
import com.example.interview.vo.BasicRes;
import com.example.interview.vo.TitleReq;
import com.example.interview.vo.UserReq;

@RestController
@CrossOrigin 
public class VoteController {

	
	@Autowired 
	private VoteService service;
	
	//新增
	@PostMapping(value = "api/vote/create")
	public BasicRes create(@RequestBody TitleReq req) {
		return service.create(req);
	}
	
	//搜尋
	@GetMapping(value = "api/vote/search")
	public List<Title> search(){
		return service.search();
	}
	
	//投票
	@PostMapping(value = "api/vote/vote")
	public BasicRes vote(@RequestBody UserReq req) {
		return service.vote(req);
	}
	
	//刪除
	@PostMapping(value = "api/vote/delete")
	public BasicRes delete(@RequestBody TitleReq req) {
		return service.delete(req);
	}
}
