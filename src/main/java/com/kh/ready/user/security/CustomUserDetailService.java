package com.kh.ready.user.security;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SqlSession session;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = session.selectOne("UserMapper.selectOneUser",username);
//		return new CustomUserDetails(user);
//	}
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		System.out.println("시작");
		CustomUserDetails user = userRepository.getUserById(id);
		System.out.println("found user!");
		System.out.println("id : " + id);
		
		return user;
	}

}
