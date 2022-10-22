package com.kh.ready.user.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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
		System.out.println("Before encoder : " + user.getUserPassword());
		String encodedPassword = encoder.encode(user.getUserPassword());
		System.out.println("After encoder : " + encodedPassword);
		user.setUserPassword(encodedPassword);
		int birthYear = user.getUserBirthday().
		LocalDate now = LocalDate.now();
		int thisYear = now.getYear();
		System.out.println(birthYear);
		System.out.println(thisYear);
		System.out.println(thisYear - birthYear);
		System.out.println("register userinfo : " + user.toString());
		
		int result = userRepository.insertUser(user);
		if(result > 0) {
			return "Insert Successfully Done!";
		}else {
			return "Insert Failed!";
		}
	}


}
