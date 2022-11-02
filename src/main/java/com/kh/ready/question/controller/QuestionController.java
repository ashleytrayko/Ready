package com.kh.ready.question.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.question.domain.Question;
import com.kh.ready.question.service.QuestionService;

@Controller
public class QuestionController {
	@Autowired
	private QuestionService qService;
	
	// 고객센터 게시글 작성
	@RequestMapping(value="/que/viewWrite.kh", method=RequestMethod.GET)
	public String showBoardWrite() {
		return "que/queWriteForm";
	}
	
	// 고객센터 게시글 등록
	@RequestMapping(value="/que/register.kh", method=RequestMethod.POST)
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
	
	
	/**
	 * 게시글 목록
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/que/list.kh", method=RequestMethod.GET)
	public ModelAndView viewList(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		/////////////////////////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = qService.getTotalCount("", "");
		int boardLimit = 100;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		// 23/5 = 4.8 + 0.9 = 5(.7)
		maxPage = (int) ((double) totalCount / boardLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		//////////////////////////////////////////////////////////////////////////
		// /board/list.kh?page=${currentPage }
		List<Question> qList = qService.printAllBoard(currentPage, boardLimit);
		if (!qList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("qList", qList);
		}
		mv.setViewName("/que/FAQList");
		return mv;
	}
	
	@RequestMapping(value="/que/myList.kh", method=RequestMethod.GET)
	public ModelAndView myQnaList(
			ModelAndView mv
			, Principal principal
			, @ModelAttribute Question que
			, @RequestParam(value="page", required=false) Integer page) {
		String queWriter = principal.getName();
		que.setQueWriter(queWriter);
		/////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = qService.getMyCount("", "");
		int boardLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double) totalCount / boardLimit + 0.9);
		startNavi = ((int)((double) currentPage / naviLimit + 0.9)-1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Question> qList = qService.printMyBoard(currentPage, boardLimit);
		if (!qList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("qList", qList);
		}
		mv.setViewName("que/myList");
		return mv;
	}
}
