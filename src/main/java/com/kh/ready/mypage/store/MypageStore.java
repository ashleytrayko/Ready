package com.kh.ready.mypage.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.user.domain.User;

public interface MypageStore {

	int insertSurvey(Survey survey, SqlSessionTemplate session);

	Survey selectMySurvey(String userId, SqlSessionTemplate session);

	int updateSurvey(Survey survey, SqlSessionTemplate session);

	User selectOneUser(String userId, SqlSessionTemplate session);

}
