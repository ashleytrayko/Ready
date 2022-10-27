package com.kh.ready.user.controller;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@GetMapping("/test")
	public String TestJoin() {
		return "common/joinForm2";
	}
	
	@ResponseBody
	@PostMapping("/emailCheck")
	public String emailCheck(String userEmail) {
		
		// 먼저 DB로가서 해당 이메일이 등록되어있는지 체크 후 없으면 메일 전송
		
		Random rand = new Random();
		int checkNum = rand.nextInt(888888) + 111111;
		
		// 이메일 보내기
		String setFrom = "readyfinalproject@gmail.com";
		String toMail = userEmail;
		String title = "회원가입 인증 이메일입니다.";
		String content = "Ready에서 보내드립니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다."
				+ "<br>" + "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.toString(checkNum);
	}
}
