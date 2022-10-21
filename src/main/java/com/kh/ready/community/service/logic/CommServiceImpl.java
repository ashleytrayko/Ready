package com.kh.ready.community.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.domain.CommReply;
import com.kh.ready.community.service.CommService;
import com.kh.ready.community.store.CommStore;

@Service
public class CommServiceImpl implements CommService{
	@Autowired
	private SqlSession session;
	@Autowired
	private CommStore cStore;

	// 게시글 등록
	@Override
	public int registerBoard(Comm comm) {
		int result = cStore.insertBoard(session, comm);
		return result;
	}
	// 게시글 전체 개수
	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = cStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}
	// 게시글 전체 출력
	@Override
	public List<Comm> printAllBoard(int currentPage, int boardLimit) {
		List<Comm> cList = cStore.selectAllBoard(session, currentPage, boardLimit);
		return cList;
	}
	// 게시글 상세보기
	@Override
	public Comm printOneByNo(Integer boardNo) {
		Comm comm = cStore.selectOneByNo(session, boardNo);
		int result = 0;
		if(comm != null) {
			result = cStore.updateBoardCount(session, boardNo);
		}
		return comm;
	}
	// 댓글출력
	@Override
	public List<CommReply> printAllReply(Integer boardNo) {
		List<CommReply> cRList = cStore.selectAllReply(session, boardNo);
		return cRList;
	}

}
