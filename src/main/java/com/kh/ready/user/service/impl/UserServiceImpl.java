package com.kh.ready.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public String userRegister(User user) {
		System.out.println("Before encoder : " + user.getPassword());
		String encodedPassword = encoder.encode(user.getPassword());
		System.out.println("After encoder : " + encodedPassword);
		user.setPassword(encodedPassword);
		System.out.println("register userinfo : " + user.toString());
		
		int result = userRepository.insertUser(user);
		if(result > 0) {
			return "Insert Successfully Done!";
		}else {
			return "Insert Failed!";
		}
	}


}
