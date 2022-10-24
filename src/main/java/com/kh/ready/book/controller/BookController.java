package com.kh.ready.book.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;
import com.kh.ready.book.service.BookService;
import com.kh.ready.user.domain.User;

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
	
	//평점 등록
	@RequestMapping(value="/book/addReview.kh", method=RequestMethod.POST)
	public ModelAndView addBookReview(ModelAndView mv, @ModelAttribute Review review, Principal principal) {
		String userId = principal.getName();
		review.setUserId(userId);
		System.out.println(review);
		int bookNo = review.getBookNo();
		int result = bService.registerReview(review);
		if(result > 0) {
			mv.setViewName("redirect:/book/detailView.kh?bookNo="+bookNo);
		} 
		return mv;
	}
	
	//평점 수정
	@RequestMapping(value="/book/modifyReview.kh", method=RequestMethod.POST)
	public String modifyBookReview(@ModelAttribute Review review) {
		int result = bService.modifyReview(review);
		return "redirect:/book/bookList.kh";
	}
	
	//평점 삭제
	@RequestMapping(value="/book/removeReview.kh", method=RequestMethod.POST)
	public String removeReview(@RequestParam("reviewNo") Integer reviewNo) {
		int result = bService.removeReview(reviewNo);
		return "";
	}
	
}
