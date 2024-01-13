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
	
	//埃-穓碝Τ⊿Τ才匡兜
	public Title findByVoteName(String voteName);
	
	//埃-埃才匡兜
	public void deleteByVoteName(String voteName);
	
	//щ布-щ布计+1
	@Modifying
	@Transactional
	@Query(value=" UPDATE Title t SET t.voteNum = t.voteNum + 1 WHERE t.id = :id ")//瘤礛盿Τ把计て,硂娩把计て琩高
	public void vote(
			@Param("id") int id);
}
