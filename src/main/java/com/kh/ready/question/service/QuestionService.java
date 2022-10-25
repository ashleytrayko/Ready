package com.kh.ready.question.service;

import org.springframework.stereotype.Service;

import com.kh.ready.question.domain.Question;

@Service
public interface QuestionService {

	int registerFAQ(Question que);

}
