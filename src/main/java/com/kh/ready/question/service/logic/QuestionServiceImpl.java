package com.kh.ready.question.service.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.question.domain.Question;
import com.kh.ready.question.service.QuestionService;
import com.kh.ready.question.store.QuestionStore;

@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private SqlSession session;
	@Autowired
	private QuestionStore qStore;

	@Override
	public int registerFAQ(Question que) {
		int result = qStore.insertFAQ(session, que);
		return result;
	}

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = qStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Question> printAllBoard(int currentPage, int boardLimit) {
		List<Question> qList = qStore.selectAllBoard(session, currentPage, boardLimit);
		return qList;
	}

	@Override
	public int getMyCount(String searchValue, String searchCondition) {
		int myCount = qStore.selectMyCount(session, searchCondition, searchValue);
		return myCount;
	}

	@Override
	public List<Question> printMyBoard(int currentPage, int boardLimit) {
		List<Question> qList = qStore.selectMyBoard(session, currentPage, boardLimit);
		return qList;
	}

}
