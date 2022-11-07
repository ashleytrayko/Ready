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

@Controller
public class HomeController {
	@Autowired
	private BookService bService;
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView home(ModelAndView mv,Principal principal) {
//		if(principal != null) {		
//			String userId = principal.getName();
//			System.out.println(userId);
//			//추천 도서 조회 (설문조사 기반)
//			List<Book> bList3 = bService.printRecommendBook(userId);
//			mv.addObject("bList3", bList3);
//		}
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
