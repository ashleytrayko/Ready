package com.kh.ready.like.service;

public interface LikeService {

	int likeCheck(int boardNo, String userId);

	int insertLike(int boardNo, String userId);

	int updateLike(int boardNo);

	int updateLikeCheck(int boardNo, String userId);

	int updateLikeCheckCancel(int boardNo, String userId);

	int updateLikeCancel(int boardNo);

	int deleteLike(int boardNo, String userId);

}
