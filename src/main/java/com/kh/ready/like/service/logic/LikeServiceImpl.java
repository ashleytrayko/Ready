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
	public int likeCheck(int boardNo, long userIndex) {
		int result = lStore.likeCheck(session, boardNo, userIndex);
		return result;
	}


	@Override
	public int insertLike(int boardNo, long userIndex) {
		int result = lStore.insertLike(session, boardNo, userIndex);
		return result;
	}


	@Override
	public int updateLike(int boardNo) {
		int result = lStore.updateLike(session, boardNo);
		return result;
	}


	@Override
	public int updateLikeCheck(int boardNo, long userIndex) {
		int result = lStore.updateLikeCheck(session, boardNo, userIndex);
		return result;
	}


	@Override
	public int updateLikeCheckCancel(int boardNo, long userIndex) {
		int result = lStore.updateLikeCheckCancel(session, boardNo, userIndex);
		return result;
	}


	@Override
	public int updateLikeCancel(int boardNo) {
		int result = lStore.updateLikeCancel(session, boardNo);
		return result;
	}


	@Override
	public int deleteLike(int boardNo, long userIndex) {
		int result = lStore.deleteLike(session, boardNo, userIndex);
		return result;
	}

}
