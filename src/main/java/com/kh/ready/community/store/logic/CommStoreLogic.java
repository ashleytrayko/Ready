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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateBoardCount(SqlSession session, Integer boardNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommReply> selectAllReply(SqlSession session, Integer boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
