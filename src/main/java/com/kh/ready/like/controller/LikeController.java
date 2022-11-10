package com.kh.ready.like.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value = "/like/likeUp.kh" , method = RequestMethod.POST)
	public int updateLike(int boardNo, String commId)throws Exception{
		
			int likeCheck = lService.likeCheck(boardNo, commId);
			if(likeCheck == 0) {
				//좋아요 처음누름
				lService.insertLike(boardNo, commId); //like테이블 삽입
				lService.updateLike(boardNo);	//게시판테이블 +1
				lService.updateLikeCheck(boardNo, commId);//like테이블 구분자 1
			}else if(likeCheck == 1) {
				lService.updateLikeCheckCancel(boardNo, commId); //like테이블 구분자0
				lService.updateLikeCancel(boardNo); //게시판테이블 - 1
				lService.deleteLike(boardNo, commId); //like테이블 삭제
			}
			return likeCheck;
	}

}
