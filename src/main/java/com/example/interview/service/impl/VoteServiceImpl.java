package com.example.interview.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.interview.constants.RtnCode;
import com.example.interview.entity.Title;
import com.example.interview.repository.TitleDao;
import com.example.interview.repository.UserDao;
import com.example.interview.service.ifs.VoteService;
import com.example.interview.vo.BasicRes;
import com.example.interview.vo.TitleReq;
import com.example.interview.vo.UserReq;
@Service
public class VoteServiceImpl implements VoteService {
	
	@Autowired
	private TitleDao titleDao;
	
	@Autowired
	private UserDao userDao;

	//新增
	@Override
	public BasicRes create(TitleReq req) {
		//基本防呆判斷前端帶入是否為空字串
		if(!StringUtils.hasText(req.getTitle().getVoteName())) {
			return new BasicRes(RtnCode.ERROR_VOTENAME_NONE);
		}
		titleDao.save(req.getTitle());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}


	//搜尋
	@Override
	public List<Title> search() {
		return titleDao.findAll();
	}

	//投票
	@Override
	public BasicRes vote(UserReq req) {
		//基本防呆
		if(!StringUtils.hasText(req.getUser().getName())) {
			return new BasicRes(RtnCode.VOTENAME_NONE);
		}
		userDao.save(req.getUser());
		titleDao.vote(req.getUser().getTitleId());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
	
	//刪除
	@Transactional
	@Override
	public BasicRes delete(TitleReq req) {
		//基本防呆判斷前端帶入是否為空字串
		if(!StringUtils.hasText(req.getTitle().getVoteName())) {
			return new BasicRes(RtnCode.ERROR_VOTENAME_NONE);
		}
		//基本防呆假如找不到投票選項
		Title title = titleDao.findByVoteName(req.getTitle().getVoteName());
		if(title==null) {
			return new BasicRes(RtnCode.FIND_VOTENAME_NONE);
		}
		//先刪除投票紀錄
		userDao.deleteAllByTitleId(title.getId());;
		//再刪除投票項目
		titleDao.deleteByVoteName(req.getTitle().getVoteName());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}

	

}
