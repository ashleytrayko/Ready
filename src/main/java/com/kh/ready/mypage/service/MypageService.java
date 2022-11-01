package com.kh.ready.mypage.service;

import java.util.List;

import com.kh.ready.mypage.domain.Survey;

public interface MypageService {

	int registSurvey(Survey survey);

	Survey printMySurvey(String userId);

}
