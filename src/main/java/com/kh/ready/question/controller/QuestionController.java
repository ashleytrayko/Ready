package com.kh.ready.question.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.question.domain.Question;
import com.kh.ready.question.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qService;
	
	@RequestMapping(value="/que/list.kh", method=RequestMethod.GET)
	public String viewFAQ() {
		return "que/FAQList";
	}
	
	
	@RequestMapping(value="que/register.kh", method=RequestMethod.POST)
	public ModelAndView registerFAQ(
			ModelAndView mv
			, @ModelAttribute Question que
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			int result = qService.registerFAQ(que);
			mv.setViewName("redirect:/que/list.kh");
		} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", e.getMessage());
				mv.setViewName("main/errorPage");
		}
		return mv;
	} 
}
