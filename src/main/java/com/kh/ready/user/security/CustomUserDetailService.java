package com.kh.ready.user.security;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.repository.impl.UserRepositoryImpl;

public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = session.selectOne("UserMapper.selectOneUser",username);
//		return new CustomUserDetails(user);
//	}
	
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		System.out.println("시작");
		com.kh.ready.user.domain.User user = userRepository.getUserById(id);
		//CustomUserDetails userDetails = new User(username, password, authorities);
		System.out.println("found user!" + user.toString());
		
		return new CustomUserDetails(user);
	}

}
