package com.kh.ready.user.repository;


import java.util.HashMap;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.security.CustomUserDetails;

public interface UserRepository {
	
	public int insertUser(User user);
	
	public User getUserById(String userId);

	public User getUserByEmail(String userEmail);

	public User getUserByNickname(String userNickname);

	public String findUserId(HashMap<String, String> paraMap);
}
