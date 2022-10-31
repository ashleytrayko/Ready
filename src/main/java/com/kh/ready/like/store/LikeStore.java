package com.kh.ready.like.store;

import org.apache.ibatis.session.SqlSession;

public interface LikeStore {

	int likeCheck(SqlSession session, int boardNo, long userIndex);

	int insertLike(SqlSession session, int boardNo, long userIndex);

	int updateLike(SqlSession session, int boardNo);

	int updateLikeCheck(SqlSession session, int boardNo, long userIndex);

	int updateLikeCheckCancel(SqlSession session, int boardNo, long userIndex);

	int updateLikeCancel(SqlSession session, int boardNo);

	int deleteLike(SqlSession session, int boardNo, long userIndex);

}
