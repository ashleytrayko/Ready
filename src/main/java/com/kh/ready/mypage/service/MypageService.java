package com.kh.ready.mypage.service;

import java.util.List;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.order.domain.Order;
import com.kh.ready.user.domain.User;

public interface MypageService {

	int registSurvey(Survey survey);

	Survey printMySurvey(String userId);

	int modifySurvey(Survey survey);

	User printOneUser(String userId);

	int modifyInfo(User user);

	String findUserByNickname(String userNickname);

	int getTotalBCount(String userId);

	List<Comm> printMyBoard(int currentPage, int boardLimit, String userId);

	List<Order> printMyOrder(String userId);

	int deleteUser(String userEmail, String textEmail);

}
