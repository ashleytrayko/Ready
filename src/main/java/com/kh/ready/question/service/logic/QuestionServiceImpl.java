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
	public int getMyCount(String searchValue, String searchCondition, String queWriter) {
		int myCount = qStore.selectMyCount(session, searchCondition, searchValue, queWriter);
		return myCount;
	}

	@Override
	public List<Question> printMyBoard(int currentPage, int boardLimit, String queWriter) {
		List<Question> qList = qStore.selectMyBoard(session, currentPage, boardLimit, queWriter);
		return qList;
		// 컨트롤러단에서 넘겨준 정보중 mapper단에서 사용할 정보들을 스토어단으로 넘겨줌
	}

	@Override
	public Question printOneByNo(Integer queNo) {
		Question que = qStore.selectOneByNo(session, queNo);
		return que;
	}

	@Override
	public List<Question> printFAQBoard(Question que) {
		List<Question> qList = qStore.selectFAQUser(session, que);
		return qList;
	}

	@Override
	public List<Question> printFAQItem(Question que) {
		List<Question> qList = qStore.selectFAQItem(session, que);
		return qList;
	}

	@Override
	public List<Question> printFAQDelivery(Question que) {
		List<Question> qList = qStore.selectFAQDelivery(session, que);
		return qList;
	}

	@Override
	public List<Question> printFAQChange(Question que) {
		List<Question> qList = qStore.selectFAQChange(session, que);
		return qList;
	}
	
	@Override
	public List<Question> printFAQEtc(Question que) {
		List<Question> qList = qStore.selectFAQEtc(session, que);
				return qList;
	}

	@Override
	public int getMangeTotalCount(String searchCondition, String searchValue) {
		int manageTotalCount = qStore.selectManageTotalCount(session, searchCondition, searchValue);
		return manageTotalCount;
	}

	@Override
	public List<Question> printManageBoard(int currentPage, int boardLimit) {
		List<Question> qList = qStore.selectManageBoard(session, currentPage, boardLimit);
		return qList;
	}


	@Override
	public int registerAdmin(Question que) {
		int result = qStore.insertAdmin(session, que);
		return result;
	}


}
