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
import org.springframework.transaction.annotation.Transactional;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.UserRepository;
import com.kh.ready.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	// 패스워드 암호화 라이브러리
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	// 메일 라이브러리
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	// 회원가입 서비스
	@Transactional
	@Override
	public String userRegister(User user) { 
		
		// 패스워드 암호화 인코딩
		String encodedPassword = encoder.encode(user.getUserPassword());
		user.setUserPassword(encodedPassword);
		
		// 입력한 생일을 통해 현재 나이(만) 구하기
		LocalDate birthDay = user.getUserBirthday().toLocalDate();
		int birthYear = birthDay.getYear();
		LocalDate now = LocalDate.now();
		int thisYear = now.getYear();
		user.setUserAge(thisYear - birthYear);
		
		int result = userRepository.insertUser(user);
		if(result > 0) {
			return "Insert Successfully Done!";
		}else {
			return "Insert Failed!";
		}
	}
	
	// 유저 아이디 중복확인
	@Override
	public String findUserById(String userId) {
		User user = userRepository.getUserById(userId);
		if(user != null) {
			return "exist";
		}else {
			return "itsOk";
		}
	}

	// 유저 이메일 중복확인
	@Override
	public String findUserByEmail(String userEmail) {
		User user = userRepository.getUserByEmail(userEmail);
		if(user != null) {
			return "exist";
		}else {
			return "itsOk";
		}
	}
	
	// 유저 닉네임 중복확인
	@Override
	public String findUserByNickname(String userNickname) {
		User user = userRepository.getUserByNickname(userNickname);
		if(user != null) {
			return "exist";
		}else {
			return "itsOk";
		}
	}
	
	// 유저 닉네임로 유저 ID 찾기
	@Override
	public User findUserByNicknameForPunish(String userNickname) {
		User user = userRepository.getUserByNickname(userNickname);
		if(user != null) {
			return user;
		}else {
			return null;
		}
	}
	
	// 유저 아이디 찾기 from 아이디 찾기
	@Override
	public String findUserId(String userName, String userEmail) {
		HashMap<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("userName", userName);
		paraMap.put("userEmail", userEmail);
		String foundId = userRepository.findUserId(paraMap);
		return foundId;
	}
	
	// 유저 비밀번호 찾기 from 비밀번호 찾기
	@Override
	public String findUserPassword(String userId, String userEmail) {
		
		// 필요한 파라미터 해쉬맵에 넣기
		HashMap<String, String> paraMap = new HashMap<String, String>();
		paraMap.put("userId", userId);
		paraMap.put("userEmail", userEmail);
		
		// 입력한 파라미터를 통해 유저가 존재하는지 확인
		int foundPassword = userRepository.findUserPassword(paraMap);
		
		// 존재할시 난수를 생성하여 비밀번호를 변경 후 메일로 발송
		if(foundPassword == 1) {
			
			// 난수생성
			Random rand = new Random();
			int newPassword1 = rand.nextInt(123456) + 987654;
			String newPassword2 = String.valueOf(newPassword1);
			
			// 암호화
			String newEncodedPassword = encoder.encode(newPassword2);
			paraMap.put("newEncodedPassword", newEncodedPassword);
			
			// 비밀번호 변경
			int result = userRepository.updateNewPassword(paraMap);
			
			// 변경성공시 메일발송
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
			// 비밀번호가 존재하지 않을시
		}else {
			return "fail";
		}
		return "success";
	}


}
