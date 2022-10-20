package com.kh.ready.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bService;
	
	
	@RequestMapping(value="/book/bookList.kh", method=RequestMethod.GET)
	public ModelAndView bookListView(ModelAndView mv) {
		List<Book> bList = bService.printAllBook();
		if(!bList.isEmpty()) {
			mv.addObject("bList", bList);
		}
		mv.setViewName("book/listView");
		return mv;
	}
}
