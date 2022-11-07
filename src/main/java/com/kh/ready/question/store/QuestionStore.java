package com.kh.ready.question.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.question.domain.Question;

@Repository
public interface QuestionStore {

	int insertFAQ(SqlSession session, Question que);

	int selectTotalCount(SqlSession session, String searchCondition, String searchValue);

	List<Question> selectAllBoard(SqlSession session, int currentPage, int boardLimit);

	int selectMyCount(SqlSession session, String searchCondition, String searchValue);

	List<Question> selectMyBoard(SqlSession session, int currentPage, int boardLimit);

	Question selectOneByNo(SqlSession session, Integer queNo);

	List<Question> selectFAQUser(SqlSession session, Question que);

	List<Question> selectFAQItem(SqlSession session, Question que);

	List<Question> selectFAQDelivery(SqlSession session, Question que);

	List<Question> selectFAQChange(SqlSession session, Question que);

	int selectManageTotalCount(SqlSession session, String searchCondition, String searchValue);

	List<Question> selectManageBoard(SqlSession session, int currentPage, int boardLimit);

}
