package com.kh.ready.like.store.logic;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.like.store.LikeStore;

@Repository
public class LikeStoreLogic implements LikeStore{

	@Override
	public int likeCheck(SqlSession session, int boardNo, String userId) {
		HashMap<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("boardNo", boardNo);
		paramMap.put("userId", userId);
		int result = session.selectOne("LikeMapper.likeCheck", paramMap);
		return result;
	}

	@Override
	public int insertLike(SqlSession session, int boardNo, String userId) {
		HashMap<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("boardNo", boardNo);
		paramMap.put("userId", userId);
		int result = session.insert("LikeMapper.insertLike", paramMap);
		return result;
	}

	@Override
	public int updateLike(SqlSession session, int boardNo) {
		int result = session.update("LikeMapper.updateLike", boardNo);
		return result;
	}

	@Override
	public int updateLikeCheck(SqlSession session, int boardNo, String userId) {
		HashMap<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("boardNo", boardNo);
		paramMap.put("userId", userId);
		int result = session.update("LikeMapper.updateLikeCheck", paramMap);
		return result;
	}

	@Override
	public int updateLikeCheckCancel(SqlSession session, int boardNo, String userId) {
		HashMap<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("boardNo", boardNo);
		paramMap.put("userId", userId);
		int result = session.update("LikeMapper.updateLikeCheckCancel", paramMap);
		return result;
	}

	@Override
	public int updateLikeCancel(SqlSession session, int boardNo) {
		int result = session.update("LikeMapper.updateLikeCancel", boardNo);
		return result;
	}

	@Override
	public int deleteLike(SqlSession session, int boardNo, String userId) {
		HashMap<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("boardNo", boardNo);
		paramMap.put("userId", userId);
		int result = session.delete("LikeMapper.deleteLike", paramMap);
		return result;
	}

}
