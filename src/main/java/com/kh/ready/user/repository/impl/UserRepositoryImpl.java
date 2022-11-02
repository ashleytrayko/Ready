package com.kh.ready.user.repository.impl;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.security.CustomUserDetails;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertUser(User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}

	@Override
	public User getUserById(String userId) {
		User user = session.selectOne("UserMapper.selectOneUser", userId);
		return user;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		User user = session.selectOne("UserMapper.selectUserByEmail", userEmail);
		return user;
	}

	@Override
	public User getUserByNickname(String userNickname) {
		User user = session.selectOne("UserMapper.selectUserByNickname",userNickname);
		return user;
	}

	@Override
	public String findUserId(HashMap<String, String> paraMap) {
		System.out.println(paraMap);
		String foundId = session.selectOne("UserMapper.ssibal",paraMap);
		System.out.println(foundId);
		return foundId;
	}

}
