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

	@Override
	public int selectMyCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
//		paramMap.put("queWriter", queWriter);
		// 로그인유저가 작성한 글만 불러올 수 있도록 paramMap으로 queWriter도 넘겨줌
		int myCount = session.selectOne("QuestionMapper.selectMyCount", paramMap);
		return myCount;
	}

	@Override
	public List<Question> selectMyBoard(SqlSession session, int currentPage, int boardLimit) {
		int offset = (currentPage-1)*boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Question> qList = session.selectList("QuestionMapper.selectMyBoard", null, rowBounds);
		return qList;
	}

	@Override
	public Question selectOneByNo(SqlSession session, Integer queNo) {
		Question que = session.selectOne("QuestionMapper.selectOneByNo", queNo);
		return que;
	}

	@Override
	public List<Question> selectFAQUser(SqlSession session, Question que) {
		List<Question> qList = session.selectList("QuestionMapper.selectFAQUser", que);
		return qList;
	}

	@Override
	public List<Question> selectFAQItem(SqlSession session, Question que) {
		List<Question> qList = session.selectList("QuestionMapper.selectFAQItem", que);
		return qList;
	}

	@Override
	public List<Question> selectFAQDelivery(SqlSession session, Question que) {
		List<Question> qList = session.selectList("QuestionMapper.selectFAQDelivery", que);
		return qList;
	}

	@Override
	public List<Question> selectFAQChange(SqlSession session, Question que) {
		List<Question> qList = session.selectList("QuestionMapper.selectFAQChange", que);
		return qList;
	}

	@Override
	public int selectManageTotalCount(SqlSession session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int manageTotalCount = session.selectOne("QuestionMapper.selectManageTotalCount", paramMap);
		return manageTotalCount;
	}

	@Override
	public List<Question> selectManageBoard(SqlSession session, int currentPage, int boardLimit) {
		int offset = (currentPage-1)*boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Question> qList = session.selectList("QuestionMapper.selectManageBoard", null, rowBounds);
		return qList;
	}

}
