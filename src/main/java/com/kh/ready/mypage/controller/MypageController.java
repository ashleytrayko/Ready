package com.kh.ready.mypage.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.service.MypageService;

@Controller
public class MypageController {

	@Autowired
	private MypageService mService;
	
	//설문조사 페이지
	@RequestMapping(value="mypage/surveyMain.kh", method=RequestMethod.GET)
	public ModelAndView showSurveyPage(ModelAndView mv, Principal principal) {
		try {
			String userId = principal.getName();
			Survey survey = mService.printMySurvey(userId);
			mv.addObject("userId", userId);
			mv.addObject("survey", survey);
			mv.setViewName("mypage/surveyMain");		
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//설문지 등록
	@RequestMapping(value="mypage/registSurvey.kh", method=RequestMethod.POST)
	public ModelAndView registSurvey(ModelAndView mv, @ModelAttribute Survey survey, Principal principal) {
		try {
			String userId = principal.getName();
			survey.setUserId(userId);
			int result = mService.registSurvey(survey);
			mv.setViewName("mypage/main");
		} catch(Exception e) {
			mv.addObject("msg", "설문조사 등록실패");
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//설문지 수정 페이지
	@RequestMapping(value="mypage/modifyForm.kh", method=RequestMethod.GET)
	public ModelAndView showModifySurvey(ModelAndView mv, Principal principal) {
		try {
			String userId = principal.getName();
			Survey survey = mService.printMySurvey(userId);
			mv.addObject("survey", survey);
			mv.setViewName("mypage/modifySurvey");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//설문지 수정
	@RequestMapping(value="mypage/modifySurvey.kh", method=RequestMethod.POST)
	public ModelAndView modifySurvey(ModelAndView mv,@ModelAttribute Survey survey) {
		int result = mService.modifySurvey(survey);
		if(result > 0) {
			mv.setViewName("mypage/surveyMain");
		} else {
			mv.addObject("msg", "수정오류");
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
}
