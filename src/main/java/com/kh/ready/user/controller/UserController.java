package com.kh.ready.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.kh.ready.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면
	@GetMapping("/login")
	public String loginPage() {
		return "/common/loginForm";
	}
	
	// 로그인 요청
	@PostMapping("/login")
	public String login() {
		return "home";
	}
	
	// 아이디 찾기 화면
	@GetMapping("/forget-id")
	public String findIdPage() {
		return "/common/forgetId";
	}
	
	// 아이디 찾기 요청
	@PostMapping("/forget-id")
	public String findId() {
		return "";
	}
	
	// 패스워드 찾기 화면
	@GetMapping("/forget-password")
	public String findPwdPage() {
		return "/common/forgetPassword";
	}
	
	// 패스워드 찾기 요청
	@PostMapping("/forget-password")
	public String findPassword() {
		return "";
	}

	@GetMapping("/user")
	public String userTest() {
		return "user/userTest";
	}
	
	// 회원가입 화면
	@GetMapping("/join")
	public String joinForm() {
		return "common/joinForm";
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
	
}
