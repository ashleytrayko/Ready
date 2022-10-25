package com.kh.ready.question.service.logic;

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

}
