package com.kh.ready.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.ready.user.domain.User;
import com.kh.ready.user.security.CustomUserDetailService;
import com.kh.ready.user.security.CustomUserDetails;
import com.kh.ready.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "/common/loginForm";
	}
	
	
	@PostMapping("/login")
	public String login() {
		return "home";
	}
	

	@GetMapping("/user")
	public String userTest() {
		return "user/userTest";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "common/joinForm";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute User user) {
		System.out.println(user.toString());
		String result = userService.userRegister(user);
		System.out.println(result);
		return "/";
	}
}
