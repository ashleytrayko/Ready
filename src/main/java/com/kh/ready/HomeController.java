package com.kh.ready;

import java.security.Principal;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.service.BookService;
import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.service.MypageService;

@Controller
public class HomeController {
	@Autowired
	private BookService bService;
	@Autowired
	private MypageService mService;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView home(ModelAndView mv,Principal principal) {
		if(principal != null) {	
			String userId = principal.getName();
			Survey survey = mService.printMySurvey(userId);
			if(survey != null) {
				String answerGender = survey.getAnswerGender();
				String answerLove = survey.getAnswerLove();
				String answerHobby = survey.getAnswerHobby();
				String answerReasion = survey.getAnswerReason();
				String answerWriter = survey.getAnswerWriter();
				//추천 도서 조회 (설문조사 기반)
				List<Book> rbook1 = bService.printRecommemdBook1(userId, answerGender);
				mv.addObject("rbook1", rbook1);
//				List<Book> rbook2 = bService.printRecommendBook2(userId, answerLove);
//				mv.addObject("rbook2", rbook2);
//				List<Book> rbook3 = bService.printRecommendBook3(userId, answerHobby);
//				mv.addObject("rbook3", rbook3);
//				List<Book> rbook4 = bService.printRecommendBook4(userId, answerHobby);
//				mv.addObject("rbook4", rbook4);
//				List<Book> rbook5 = bService.printRecommendBook5(userId, answerHobby);
//				mv.addObject("rbook5", rbook5);
			}
		}
		//베스트셀러 조회(메인페이지)
		List<Book> bList1 = bService.printBestSeller();
		//신간 조회
		List<Book> bList2 = bService.printNewBook();
		//소설
		List<Book> bList4 = bService.printNovel();
		//만화
		List<Book> bList5 = bService.printComic();
		//자기계발
		List<Book> bList6 = bService.printStudy();
			mv.addObject("bList1", bList1);
			mv.addObject("bList2", bList2);
			mv.addObject("bList4", bList4);
			mv.addObject("bList5", bList5);
			mv.addObject("bList6", bList6);
			mv.setViewName("home");
		
		mv.addObject("principal", principal);
		
		return mv;
	}
	
}
