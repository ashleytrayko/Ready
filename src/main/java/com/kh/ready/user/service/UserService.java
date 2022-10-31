package com.kh.ready.user.service;

import com.kh.ready.user.domain.User;

public interface UserService {
	
	// 회원가입
	public String userRegister(User user);
	
	// 아이디찾기
	public String findUserById(String userId);
	
	// 메일 중복확인
	public String findUserByEmail(String userEmail);
	
	// 닉네임 중복확인
	public String findUserByNickname(String userNickname);
}
