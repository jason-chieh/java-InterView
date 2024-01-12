package com.example.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.interview.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	//�R�����خɧ벼�����]�����@�_�R��
	public void deleteAllByTitleId(int titleId);
}
