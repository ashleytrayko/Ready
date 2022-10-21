package com.kh.ready.community.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.domain.CommReply;
import com.kh.ready.community.service.CommService;

@Controller
public class CommController {
	@Autowired private CommService cService;
	
	@RequestMapping(value="/comm/viewWrite.kh", method=RequestMethod.GET)
	public String showBoardWrite() {
		return "comm/boardWriteForm";
	}
	
	/**
	 * 게시글 등록
	 * @param mv
	 * @param comm
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="comm/register.kh", method=RequestMethod.POST)
	public ModelAndView registerBoard(
			ModelAndView mv
			, @ModelAttribute Comm comm
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			int result = cService.registerBoard(comm);
			mv.setViewName("redirect:/comm/list.kh");
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
	@RequestMapping(value="comm/list.kh", method=RequestMethod.GET)
	public ModelAndView viewList(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		/////////////////////////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = cService.getTotalCount("", "");
		int boardLimit = 10;
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
		List<Comm> cList = cService.printAllBoard(currentPage, boardLimit);
		if (!cList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("/comm/listView");
		return mv;
	}
	
	/*
	 * @RequestMapping(value="/comm/detail.kh", method=RequestMethod.POST) public
	 * ModelAndView detailView( ModelAndView mv , @RequestParam("boardNo") Integer
	 * boardNo , @RequestParam("page") Integer page , HttpSession session) { Comm
	 * comm = cService.printOneByNo(boardNo); List<CommReply> cRList =
	 * cService.printAllReply(boardNo); }
	 */
		
	

	
}
