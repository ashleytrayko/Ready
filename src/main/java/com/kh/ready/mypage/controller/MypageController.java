package com.kh.ready.mypage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.service.MypageService;

@Controller
public class MypageController {

	@Autowired
	private MypageService mService;
	
	@RequestMapping(value="mypage/registSurvey.kh", method=RequestMethod.POST)
	public void registSurvey(ModelAndView mv, @ModelAttribute Survey survey) {
		try {
			int result = mService.registSurvey(survey);
			mv.setViewName("mypage/main");
		} catch(Exception e) {
			mv.addObject("msg", "설문조사 등록실패");
			mv.setViewName("main/errorPage");
		}
	}
}
