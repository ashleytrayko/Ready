package com.kh.ready.community.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.domain.CommReply;

public interface CommStore {
	// 게시글 등록
	int insertBoard(SqlSession session, Comm comm);
	// 게시글 전체 출력
	int selectTotalCount(SqlSession session, String searchCondition, String searchValue);
	// 게시글 전체 갯수
	List<Comm> selectAllBoard(SqlSession session, int currentPage, int boardLimit);
	
	Comm selectOneByNo(SqlSession session, Integer boardNo);
	
	int updateBoardCount(SqlSession session, Integer boardNo);
	
	List<CommReply> selectAllReply(SqlSession session, Integer boardNo);
	
	int updateComm(SqlSession session, Comm comm);
	
	int updateBoardRemove(SqlSession session, int boardNo);
	
	int insertReply(SqlSession session, CommReply cReply);
	
	int deleteReply(SqlSession session, Integer cReplyNo);
	
	int updateReply(SqlSession session, CommReply cReply);

}
