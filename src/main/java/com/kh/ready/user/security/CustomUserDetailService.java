package com.kh.ready.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	// Security가 로그인시 인터셉트해서 사용하는 메소드 
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("Login Start!");
		User user = userRepository.getUserById(userId);
		if (user != null) {
			return new CustomUserDetails(user);
		}
		return null;
	}

}
