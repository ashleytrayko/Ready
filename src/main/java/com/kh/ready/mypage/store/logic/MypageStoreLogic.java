package com.kh.ready.mypage.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.store.MypageStore;
import com.kh.ready.user.domain.User;

@Repository
public class MypageStoreLogic implements MypageStore{

	@Override
	public int insertSurvey(Survey survey, SqlSessionTemplate session) {
		int result = session.insert("MypageMapper.InsertSurvey", survey);
		return result;
	}

	@Override
	public Survey selectMySurvey(String userId, SqlSessionTemplate session) {
		Survey survey = session.selectOne("MypageMapper.selectMySurvey", userId);
		return survey;
	}

	@Override
	public int updateSurvey(Survey survey, SqlSessionTemplate session) {
		int result = session.update("MypageMapper.updateMySurvey", survey);
		return result;
	}

	@Override
	public User selectOneUser(String userId, SqlSessionTemplate session) {
		User user = session.selectOne("MypageMapper.selectOneUser", userId);
		return user;
	}

	@Override
	public int updateInfo(User user, SqlSessionTemplate session) {
		int result = session.update("MypageMapper.updateUser", user);
		return result;
	}

	@Override
	public User getUserByNickname(String userNickname, SqlSessionTemplate session) {
		User user = session.selectOne("MypageMapper.selectUserByNickname", userNickname);
		return user;
	}

}
