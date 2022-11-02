package com.kh.ready.user.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
		// password encoding
		System.out.println("Before encoder : " + user.getUserPassword());
		String encodedPassword = encoder.encode(user.getUserPassword());
		System.out.println("After encoder : " + encodedPassword);
		user.setUserPassword(encodedPassword);
		
		// Setting UserAge
		LocalDate birthDay = user.getUserBirthday().toLocalDate();
		int birthYear = birthDay.getYear();
		LocalDate now = LocalDate.now();
		int thisYear = now.getYear();
		user.setUserAge(thisYear- birthYear);
		System.out.println("register userinfo : " + user.toString());
		
		int result = userRepository.insertUser(user);
		if(result > 0) {
			return "Insert Successfully Done!";
		}else {
			return "Insert Failed!";
		}
	}

	@Override
	public String findUserById(String userId) {
		User user = userRepository.getUserById(userId);
		if(user != null) {
			return "exist";
		}else {
			return "itsOk";
		}
	}

	@Override
	public String findUserByEmail(String userEmail) {
		User user = userRepository.getUserByEmail(userEmail);
		if(user != null) {
			return "exist";
		}else {
			return "itsOk";
		}
	}

	@Override
	public String findUserByNickname(String userNickname) {
		User user = userRepository.getUserByNickname(userNickname);
		if(user != null) {
			return "exist";
		}else {
			return "itsOk";
		}
	}

	@Override
	public String findUserId(String userName, String userEmail) {
		HashMap<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("userNameSSIBAL", userName);
		paraMap.put("userEmailSSIBAL", userEmail);
		String foundId = userRepository.findUserId(paraMap);
		if(foundId.equals("")) {
			return "NULL";
		}
		return foundId;
	}


}
