package com.kh.ready.like.store.logic;


import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.like.store.LikeStore;

@Repository
public class LikeStoreLogic implements LikeStore{

	@Override
	public int selectLikeCheck(SqlSession session, int boardNo, String commId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("boardNo", boardNo);
		param.put("commId", commId);
		int result = session.selectOne("LikeMapper.selectLikeCheck", param);
		return result;
	}

	@Override
	public void insertLike(SqlSession session, int boardNo, String commId){
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("boardNo", boardNo);
		param.put("commId", commId);
		session.insert("LikeMapper.insertLike", param);
	}

	@Override
	public void updateLike(SqlSession session, int boardNo) {
		session.update("LikeMapper.updateLike", boardNo);
	}

	@Override
	public void updateLikeCheck(SqlSession session, int boardNo, String commId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("boardNo", boardNo);
		param.put("commId", commId);
		session.update("LikeMapper.updateLikeCheck", param);
	}

	@Override
	public void updateLikeCheckCancel(SqlSession session, int boardNo, String commId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("boardNo", boardNo);
		param.put("commId", commId);
		session.update("LikeMapper.updateLikeCheckCancel", param);
	}

	@Override
	public void updateLikeCancel(SqlSession session, int boardNo) {
		session.update("LikeMapper.updateLikeCancel", boardNo);
	}

	@Override
	public void deleteLike(SqlSession session, int boardNo, String commId) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("boardNo", boardNo);
		param.put("commId", commId);
		session.delete("LikeMapper.deleteLike", param);
	}




}
