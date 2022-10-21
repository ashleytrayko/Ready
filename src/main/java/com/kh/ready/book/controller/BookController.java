package com.kh.ready.book.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bService;
	
	//도서 목록 조회
	@RequestMapping(value="/book/bookList.kh", method=RequestMethod.GET)
	public ModelAndView bookListView(ModelAndView mv) {
		List<Book> bList = bService.printAllBook();
		if(!bList.isEmpty()) {
			mv.addObject("bList", bList);
		}
		mv.setViewName("book/listView");
		return mv;
	}
	
	//도서 세부조회
	@RequestMapping(value="/book/detailView.kh", method=RequestMethod.GET)
	public ModelAndView bookDetailView(ModelAndView mv, @RequestParam("bookNo") Integer bookNo) {
		try {
			Book book = bService.printOneByNo(bookNo);
			mv.addObject("book", book);
			mv.setViewName("book/detailView");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
}
