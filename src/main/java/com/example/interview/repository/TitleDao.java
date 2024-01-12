package com.example.interview.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.interview.entity.Title;

@Repository
public interface TitleDao extends JpaRepository<Title, Integer>{
	
	//刪除功能-搜尋有沒有符合的選項
	public Title findByVoteName(String voteName);
	
	//刪除功能-刪除符合的選項
	public void deleteByVoteName(String voteName);
	
	//投票功能-投票人數+1
	@Modifying
	@Transactional
	@Query(value=" UPDATE interviewvote.title "
			+ " SET vote_num = vote_num + 1 "
			+ " WHERE id = :id  ",nativeQuery = true)
	public void vote(
			@Param("id") int id);
}
