package com.kh.ready.question.store.logic;

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

}
