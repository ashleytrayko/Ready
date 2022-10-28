package com.kh.ready.user.controller;

import java.security.Principal;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.security.CustomUserDetailService;
import com.kh.ready.user.security.CustomUserDetails;
import com.kh.ready.user.security.oauth.PrincipalOAuth2UserService;
import com.kh.ready.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PrincipalOAuth2UserService principalOAuth2UserService;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	
	/**
	 * 
	 * 화면 이동 url
	 */
	
	// 로그인 화면
	@GetMapping("/login")
	public String loginPage() {
		return "/common/loginForm";
	}
	
	// 아이디 찾기 화면
	@GetMapping("/forget-id")
	public String findIdPage() {
		return "/common/forgetId";
	}

	// 패스워드 찾기 화면
	@GetMapping("/forget-password")
	public String findPwdPage() {
		return "/common/forgetPassword";
	}
	
	// 회원가입 화면
	@GetMapping("/join")
	public String joinForm() {
		return "/common/joinForm";
	}

	// user 화면
	@GetMapping("/user")
	public String userTest() {
		return "/user/userTest";
	}
	
	
	/**
	 * 요청 url 모음
	 */
	
	
	// 로그인 요청
	@PostMapping("/login")
	public String login() {
		return "home";
	}
	
	
	// 아이디 찾기 요청
	@PostMapping("/forget-id")
	public String findId() {
		return "";
	}
	
	// 패스워드 찾기 요청
	@PostMapping("/forget-password")
	public String findPassword() {
		return "";
	}

	// 회원가입 요청
	@PostMapping("/join")
	public String join(@ModelAttribute User user) {
		String result = userService.userRegister(user);
		return "home";
	}
	
	// 아이디 중복확인
	@ResponseBody
	@GetMapping("/checkId")
	public String checkId(@RequestParam("userId") String userId) {
		String result = userService.findUserById(userId);
		if(result.equals("itsOk")) {
			return "itsOk";
		}else {
			return "exist";
		}
	}
	
	// 이메일 확인
	@ResponseBody
	@PostMapping("/emailCheck")
	public String emailCheck(String userEmail) {
		
		// 먼저 DB로가서 해당 이메일이 등록되어있는지 체크 후 없으면 메일 전송
		String result = userService.findUserByEmail(userEmail);
		if(result.equals("exist")) {
			return "exist";
		}else {
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
	
	
	//설문조사 페이지 이동
	@RequestMapping(value="/mypage/survey.kh", method=RequestMethod.GET)
	public String showSurvey() {
		return "mypage/survey";
	}
	
	//마이페이지 이동
	@RequestMapping(value="/user/mypage.kh", method=RequestMethod.GET)
	public String showMyPage() {
		return "mypage/main";
	}
	
}
