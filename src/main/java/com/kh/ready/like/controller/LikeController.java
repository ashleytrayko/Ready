package com.kh.ready.like.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ready.like.domain.Like;
import com.kh.ready.like.service.LikeService;

@Controller
public class LikeController {
	@Autowired
	private LikeService lService;
	
	@ResponseBody
	@RequestMapping(value="/like/recomm.kh", method=RequestMethod.POST)
	public int commLike(
			int boardNo
//			, long userIndex
			, Principal principal
			, Like like) {
		String userId = principal.getName();
		like.setUserId(userId);
		
		int likeCheck = lService.likeCheck(boardNo, userId);
		try {
				
			if(likeCheck == 0) {
				lService.insertLike(boardNo, userId);
				lService.updateLike(boardNo);
				lService.updateLikeCheck(boardNo, userId);
			}else if(likeCheck == 1) {
				lService.updateLikeCheckCancel(boardNo, userId);
				lService.updateLikeCancel(boardNo);
				lService.deleteLike(boardNo, userId);
			}
		} catch (Exception e) {
			System.out.println("에러발생");
		}
		return likeCheck;
	}

}
