package com.kh.ready.like.service;

public interface LikeService {

	int likeCheck(int boardNo, long userIndex);

	int insertLike(int boardNo, long userIndex);

	int updateLike(int boardNo);

	int updateLikeCheck(int boardNo, long userIndex);

	int updateLikeCheckCancel(int boardNo, long userIndex);

	int updateLikeCancel(int boardNo);

	int deleteLike(int boardNo, long userIndex);

}
