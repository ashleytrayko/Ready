package com.kh.ready.user.repository;


import java.util.HashMap;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.security.CustomUserDetails;

public interface UserRepository {
	
	// 유저 등록
	public int insertUser(User user);
	
	// 로그인시 사용하는 메소드
	public User getUserById(String userId);

	// 메일 중복확인시 사용하는 메소드
	public User getUserByEmail(String userEmail);

	// 닉네임 중복확인시 사용하는 메소드
	public User getUserByNickname(String userNickname);

	// 잃어버린 아이디 찾기
	public String findUserId(HashMap<String, String> paraMap);

	// 비밀번호를 잃어버린 회원이 존재하는지 확인
	public int findUserPassword(HashMap<String, String> paraMap);

	// 난수로 임시비밀번호 설정
	public int updateNewPassword(HashMap<String, String> paraMap);
}
