package com.kh.ready.mypage.store;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.mypage.domain.Survey;

public interface MypageStore {

	int insertSurvey(Survey survey, SqlSessionTemplate session);

}
