package com.kh.ready.user.repository;


import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.security.CustomUserDetails;

public interface UserRepository {
	
	public int insertUser(User user);
	
	public User getUserById(String userId);
}
