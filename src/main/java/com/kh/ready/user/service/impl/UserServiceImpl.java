package com.kh.ready.user.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
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
		paraMap.put("userName", userName);
		paraMap.put("userEmail", userEmail);
		String foundId = userRepository.findUserId(paraMap);
		return foundId;
	}

	@Override
	public String findUserPassword(String userId, String userEmail) {
		HashMap<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("userId", userId);
		paraMap.put("userEmail", userEmail);
		int foundPassword = userRepository.findUserPassword(paraMap);
		System.out.println(foundPassword);
		if(foundPassword == 1) {
			Random rand = new Random();
			int newPassword1 = rand.nextInt(123456) + 987654;
			String newPassword2 = String.valueOf(newPassword1);
			String newEncodedPassword = encoder.encode(newPassword2);
			paraMap.put("newEncodedPassword", newEncodedPassword);
			int result = userRepository.updateNewPassword(paraMap);
			System.out.println(result);
			if(result == 1) {
				String setFrom = "readyfinalproject@gmail.com";
				String toMail = userEmail;
				String title = "비밀번호 찾기 안내 메일입니다.";
				String content = "Ready에서 보내드립니다." + "<br><br>" + "변경된 비밀번호는 " + newPassword2 + "입니다."
						+ "<br>" + "로그인 하신 후 꼭 비밀번호를 변경해 주세요.";
				try {
					MimeMessage message = mailSender.createMimeMessage();
					MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
					helper.setFrom(setFrom);
					helper.setTo(toMail);
					helper.setSubject(title);
					helper.setText(content, true);
					mailSender.send(message);
					
				} catch(MessagingException e) {
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("비번 없어요!");
			return "fail";
		}
		return "success";
	}


}
