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

	//�s�W
	@Override
	public BasicRes create(TitleReq req) {
		//�򥻨��b�P�_�e�ݱa�J�O�_���Ŧr��
		if(!StringUtils.hasText(req.getTitle().getVoteName())) {
			return new BasicRes(RtnCode.ERROR_VOTENAME_NONE);
		}
		titleDao.save(req.getTitle());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}


	//�j�M
	@Override
	public List<Title> search() {
		return titleDao.findAll();
	}

	//�벼
	@Override
	public BasicRes vote(UserReq req) {
		//�򥻨��b
		if(!StringUtils.hasText(req.getUser().getName())) {
			return new BasicRes(RtnCode.VOTENAME_NONE);
		}
		userDao.save(req.getUser());
		titleDao.vote(req.getUser().getTitleId());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}
	
	//�R��
	@Transactional
	@Override
	public BasicRes delete(TitleReq req) {
		//�򥻨��b�P�_�e�ݱa�J�O�_���Ŧr��
		if(!StringUtils.hasText(req.getTitle().getVoteName())) {
			return new BasicRes(RtnCode.ERROR_VOTENAME_NONE);
		}
		//�򥻨��b���p�䤣��벼�ﶵ
		Title title = titleDao.findByVoteName(req.getTitle().getVoteName());
		if(title==null) {
			return new BasicRes(RtnCode.FIND_VOTENAME_NONE);
		}
		//���R���벼����
		userDao.deleteAllByTitleId(title.getId());;
		//�A�R���벼����
		titleDao.deleteByVoteName(req.getTitle().getVoteName());
		return new BasicRes(RtnCode.SUCCESSFUL);
	}

	

}
