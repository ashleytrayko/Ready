package com.kh.ready.like.service.logic;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.like.service.LikeService;
import com.kh.ready.like.store.LikeStore;

@Service
public class LikeServiceImpl implements LikeService{
	@Autowired
	private LikeStore lStore;
	@Autowired
	private SqlSession session;
	
	@Override
	public int likeCheck(int boardNo, String commId) {
		int result = lStore.selectLikeCheck(session, boardNo, commId);
		return result;
	}

	@Override
	public void insertLike(int boardNo, String commId){
		lStore.insertLike(session, boardNo, commId);
	}

	@Override
	public void updateLike(int boardNo) {
		lStore.updateLike(session, boardNo);
	}

	@Override
	public void updateLikeCheck(int boardNo, String commId) {
		lStore.updateLikeCheck(session, boardNo, commId);
	}

	@Override
	public void updateLikeCheckCancel(int boardNo, String commId) {
		lStore.updateLikeCheckCancel(session, boardNo, commId);
	}

	@Override
	public void updateLikeCancel(int boardNo) {
		lStore.updateLikeCancel(session, boardNo);
	}

	@Override
	public void deleteLike(int boardNo, String commId) {
		lStore.deleteLike(session, boardNo, commId);
	}
	
		
}
