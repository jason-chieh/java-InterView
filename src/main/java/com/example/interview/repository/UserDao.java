package com.example.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.interview.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	//刪除項目時投票紀錄也必須一起刪除
	public void deleteAllByTitleId(int titleId);
}
