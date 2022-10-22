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

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		System.out.println("시작");
		User user = userRepository.getUserById(userId);
		if (user != null) {
			return new CustomUserDetails(user);
		}
		return null;
	}

}
