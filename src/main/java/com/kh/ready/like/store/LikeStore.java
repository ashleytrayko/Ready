package com.kh.ready.like.store;

import org.apache.ibatis.session.SqlSession;

public interface LikeStore {

	int selectLikeCheck(SqlSession session, int boardNo, String commId);

	void insertLike(SqlSession session, int boardNo, String commId);

	void updateLike(SqlSession session, int boardNo);

	void updateLikeCheck(SqlSession session, int boardNo, String commId);

	void updateLikeCheckCancel(SqlSession session, int boardNo, String commId);

	void updateLikeCancel(SqlSession session, int boardNo);

	void deleteLike(SqlSession session, int boardNo, String commId);


}
