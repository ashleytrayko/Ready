package com.kh.ready.mypage.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.mypage.domain.Survey;

public interface MypageStore {

	int insertSurvey(Survey survey, SqlSessionTemplate session);

	Survey selectMySurvey(String userId, SqlSessionTemplate session);

}
