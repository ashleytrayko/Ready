package com.kh.ready.user.repository.impl;


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
	public User getUserById(String id, SqlSession sqlSession) {
		User user = session.selectOne("UserMapper.selectOneUser", id);
		return user;
	}

}
