package com.kh.ready.question.store;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.question.domain.Question;

@Repository
public interface QuestionStore {

	int insertFAQ(SqlSession session, Question que);

}
