package com.kh.ready.mypage.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.store.MypageStore;

@Repository
public class MypageStoreLogic implements MypageStore{

	@Override
	public int insertSurvey(Survey survey, SqlSessionTemplate session) {
		int result = session.insert("MypageMapper.InsertSurvey", survey);
		return result;
	}

}
