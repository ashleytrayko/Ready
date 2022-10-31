package com.kh.ready.like.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.like.service.LikeService;

@Controller
public class LikeController {
	@Autowired
	private LikeService lService;
	
	@ResponseBody
	@RequestMapping(value="/like/recomm.kh", method=RequestMethod.POST)
	public int commLike(
			int boardNo
			, long userIndex) {
		int likeCheck = lService.likeCheck(boardNo, userIndex);
		try {
				
			if(likeCheck == 0) {
				lService.insertLike(boardNo, userIndex);
				lService.updateLike(boardNo);
				lService.updateLikeCheck(boardNo, userIndex);
			}else if(likeCheck == 1) {
				lService.updateLikeCheckCancel(boardNo, userIndex);
				lService.updateLikeCancel(boardNo);
				lService.deleteLike(boardNo, userIndex);
		}
		} catch (Exception e) {
			System.out.println("에러발생");
		}
		return likeCheck;
	}

}
