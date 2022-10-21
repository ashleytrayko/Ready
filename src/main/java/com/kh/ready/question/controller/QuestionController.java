package com.kh.ready.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ready.question.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qService;
	
	@RequestMapping(value="/que/list.kh", method=RequestMethod.GET)
	public String viewFAQ() {
		return "que/FAQList";
	}
}
