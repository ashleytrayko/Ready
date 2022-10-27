package com.kh.ready.question.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.question.domain.Question;
import com.kh.ready.question.store.QuestionStore;

@Repository
public class QuestionStoreLogic implements QuestionStore{

	@Override
	public int insertFAQ(SqlSession session, Question que) {
		int result = session.insert("QuestionMapper.insertFAQ", que);
		return result;
	}

	@Override
	public int selectTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("QuestionMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Question> selectAllBoard(SqlSession session, int currentPage, int boardLimit) {
		int offset = (currentPage-1)*boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Question> qList = session.selectList("QuestionMapper.selectAllBoard", null, rowBounds);
		return qList;
	}

}
