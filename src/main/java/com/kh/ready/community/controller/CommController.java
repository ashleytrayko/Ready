package com.kh.ready.community.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.community.domain.Comm;
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
	
	
		
	

	
}
