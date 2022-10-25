package com.kh.ready.community.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.domain.CommReply;
import com.kh.ready.community.store.CommStore;

@Repository
public class CommStoreLogic implements CommStore{

	@Override
	public int insertBoard(SqlSession session, Comm comm) {
		int result = session.insert("CommMapper.insertBoard", comm);
		return result;
	}

	@Override
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("CommMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Comm> selectAllBoard(SqlSession session, int currentPage, int boardLimit) {
		int offset = (currentPage-1)*boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Comm> cList = session.selectList("CommMapper.selectAllBoard", null, rowBounds);
		return cList;
	}

	@Override
	public Comm selectOneByNo(SqlSession session, Integer boardNo) {
		Comm comm = session.selectOne("CommMapper.selectOneByNo", boardNo);
		return comm;
	}

	@Override
	public int updateBoardCount(SqlSession session, Integer boardNo) {
		int result = session.update("CommMapper.updateCount", boardNo);
		return result;
	}

	@Override
	public List<CommReply> selectAllReply(SqlSession session, Integer boardNo) {
		List<CommReply> cRList = session.selectList("CommReplyMapper.selectAllReply", boardNo);
		return cRList;
	}

	@Override
	public int updateComm(SqlSession session, Comm comm) {
		int result = session.update("CommMapper.updateComm", comm);
		return result;
	}

	@Override
	public int updateBoardRemove(SqlSession session, int boardNo) {
		int result = session.update("CommMapper.updateBoardRemove", boardNo);
		return result;
	}

	@Override
	public int insertReply(SqlSession session, CommReply cReply) {
		int result = session.insert("CommReplyMapper.insertReply", cReply);
		return result;
	}

	@Override
	public int deleteReply(SqlSession session, Integer cReplyNo) {
		int result = session.update("CommReplyMapper.deleteReply", cReplyNo);
		return result;
	}

	@Override
	public int updateReply(SqlSession session, CommReply cReply) {
		int result = session.update("CommReplyMapper.updateReply", cReply);
		return result;
	}

}
