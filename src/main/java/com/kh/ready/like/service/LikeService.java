package com.kh.ready.like.service;

public interface LikeService {

	int likeCheck(int boardNo, String commId);

	void insertLike(int boardNo, String commId);

	void updateLike(int boardNo);

	void updateLikeCheck(int boardNo, String commId);

	void updateLikeCheckCancel(int boardNo, String commId);

	void updateLikeCancel(int boardNo);

	void deleteLike(int boardNo, String commId);

	

}
