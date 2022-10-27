package com.kh.ready.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.ready.question.domain.Question;

@Service
public interface QuestionService {

	int registerFAQ(Question que);

	int getTotalCount(String string, String string2);

	List<Question> printAllBoard(int currentPage, int boardLimit);

}
