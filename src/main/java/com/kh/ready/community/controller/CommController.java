package com.kh.ready.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommController {

	@RequestMapping(value="/comm/header.kh", method=RequestMethod.GET)
	public String headerView() {
		return "community/commMain";
	}
	
	
}
