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
	
	//�R���\��-�j�M���S���ŦX���ﶵ
	public Title findByVoteName(String voteName);
	
	//�R���\��-�R���ŦX���ﶵ
	public void deleteByVoteName(String voteName);
	
	//�벼�\��-�벼�H��+1
	@Modifying
	@Transactional
	@Query(value=" UPDATE interviewvote.title "
			+ " SET vote_num = vote_num + 1 "
			+ " WHERE id = :id  ",nativeQuery = true)
	public void vote(
			@Param("id") int id);
}