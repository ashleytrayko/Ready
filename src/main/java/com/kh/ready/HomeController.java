package com.kh.ready;

import java.security.Principal;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	public ModelAndView home(ModelAndView mv, Principal principal) {
		//베스트셀러 조회(메인페이지)
		List<Book> bList1 = bService.printBestSeller();
		List<Book> bList2 = bService.printNewBook();
			mv.addObject("bList1", bList1);
			mv.addObject("bList2", bList2);
			mv.setViewName("home");
		
		mv.addObject("principal", principal);
		
		return mv;
	}
	
}
