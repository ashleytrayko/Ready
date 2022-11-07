package com.kh.ready.mypage.service;

import java.util.List;

import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.user.domain.User;

public interface MypageService {

	int registSurvey(Survey survey);

	Survey printMySurvey(String userId);

	int modifySurvey(Survey survey);

	User printOneUser(String userId);

	int modifyInfo(User user);

	String findUserByNickname(String userNickname);

}
