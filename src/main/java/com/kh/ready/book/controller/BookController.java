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
	public ModelAndView bookListView(ModelAndView mv, @RequestParam(value="page", required=false) Integer page) {
		//페이징
		int currentPage = (page != null) ? page : 1;
		int totalCount = bService.getTotalCount("", "");
		int bookLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/bookLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit +1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		//도서 목록 조회
		List<Book> bList = bService.printAllBook(currentPage, bookLimit);
		if(!bList.isEmpty()) {
			mv.addObject("urlVal", "bookList");
			mv.addObject("currentPgae", currentPage);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("bList", bList);
		}
		mv.setViewName("book/listView");
		return mv;
	}
	
	
	//도서 세부조회
	@RequestMapping(value="/book/detailView.kh", method=RequestMethod.GET)
	public ModelAndView bookDetailView(ModelAndView mv, @RequestParam("bookNo") Integer bookNo, HttpSession session, Principal principal) {
		try {
			Book book = bService.printOneByNo(bookNo);
			List<Review> rList = bService.printAllReview(bookNo);
			session.setAttribute("bookNo", book.getBookNo());
			mv.addObject("rList", rList);
			mv.addObject("book", book);
			mv.addObject("principal", principal);
			mv.setViewName("book/detailView");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//도서 검색
	@RequestMapping(value="book/searchBook.kh", method=RequestMethod.GET)
	public ModelAndView searchBookList(ModelAndView mv, 
								@RequestParam("searchCondition")String searchCondition,
								@RequestParam("searchValue")String searchValue,
								@RequestParam(value="page", required=false) Integer page) {
		try {
			//페이징
			int currentPage = (page != null) ? page : 1;
			int totalCount = bService.getTotalCount(searchCondition, searchValue);
			int bookLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/bookLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit +1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			//검색
			List<Book> bList = bService.printAllByValue(searchCondition, searchValue, currentPage, bookLimit);
			if(!bList.isEmpty()) {
				mv.addObject("bList", bList);
			} else {
				mv.addObject("bList", null);
			}
			mv.addObject("urlVal", "searchBook");
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("searchValue", searchValue);
			mv.addObject("currentPage", currentPage);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("book/listView");
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("main/errorPage");
		}
		return mv;
	}
	
	//카테고리 조회
	@RequestMapping(value="/book/category.kh", method=RequestMethod.GET)
	public ModelAndView showCategory(ModelAndView mv, @RequestParam("category")String category, @RequestParam(value="page", required=false) Integer page) {
		try {
			//페이징
			int currentPage = (page != null) ? page : 1;
			int totalCount = bService.getTotalCatrgoryCount(category);
			int bookLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/bookLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit +1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			//도서 목록
			List<Book> bList = bService.printAllByCategory(category, currentPage, bookLimit);
			if(!bList.isEmpty()) {
				mv.addObject("bList", bList);
			} else {
				mv.addObject("bList", null);
			}
			mv.addObject("category", category);
			mv.addObject("currentPage", currentPage);
			mv.addObject("maxPage", maxPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.setViewName("book/listMain");
		} catch(Exception e) {
			mv.addObject("msg", e.toString()).setViewName("main/errorPage");
			}
		return mv;
	}
	
	//평점 등록
	@RequestMapping(value="/book/addReview.kh", method=RequestMethod.POST)
	public ModelAndView addBookReview(ModelAndView mv, @ModelAttribute Review review, Principal principal) {
		String userId = principal.getName();
		review.setUserId(userId);
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
		int bookNo = review.getBookNo();
		int result = bService.modifyReview(review);
		return "redirect:/book/detailView.kh?bookNo="+bookNo;
	}
	
	//평점 삭제
	@RequestMapping(value="/book/removeReview.kh", method=RequestMethod.POST)
	public String removeReview(@RequestParam("reviewNo") Integer reviewNo, @RequestParam("bookNo") Integer bookNo) {
		Review review = new Review();
		review.setBookNo(bookNo);
		review.setReviewNo(reviewNo);
		bService.removeReview(review);
		return "redirect:/book/detailView.kh?bookNo="+bookNo;
	}
	
	//내 후기 조회
	@RequestMapping(value="/mypage/myReview.kh", method=RequestMethod.GET)
	public ModelAndView printMyReview(ModelAndView mv, @RequestParam(value="page", required=false) Integer page, Principal principal) {
		try {
			String userId = principal.getName();
			//페이징
			int currentPage = (page != null) ? page : 1;
			int totalCount = bService.getTotalMyReviewCount(userId);
			int reviewLimit = 10;
			int naviLimit = 5;
			int maxPage;
			int startNavi;
			int endNavi;
			maxPage = (int)((double)totalCount/reviewLimit + 0.9);
			startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit +1;
			endNavi = startNavi + naviLimit - 1;
			if(maxPage < endNavi) {
				endNavi = maxPage;
			}
			List<Review> rList = bService.printMyReview(userId, currentPage, reviewLimit);
			if(!rList.isEmpty()) {
				mv.addObject("userId", userId);
				mv.addObject("currentPage", currentPage);
				mv.addObject("maxPage", maxPage);
				mv.addObject("startNavi", startNavi);
				mv.addObject("endNavi", endNavi);
				mv.addObject("rList", rList);
			}
			mv.setViewName("mypage/myReview");
		} catch(Exception e ) {
			mv.addObject("msg", e.toString()).setViewName("main/errorPage");
		}
		return mv;
	}
}
