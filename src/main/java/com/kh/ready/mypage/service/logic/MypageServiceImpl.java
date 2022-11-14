package com.kh.ready.mypage.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.service.MypageService;
import com.kh.ready.mypage.store.MypageStore;
import com.kh.ready.order.domain.Order;
import com.kh.ready.user.domain.User;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired
	private SqlSessionTemplate session;
	@Autowired
	private MypageStore mStore;
	
	@Override
	public int registSurvey(Survey survey) {
		int result = mStore.insertSurvey(survey, session);
		return result;
	}

	@Override
	public Survey printMySurvey(String userId) {
		Survey survey = mStore.selectMySurvey(userId, session);
		return survey;
	}

	@Override
	public int modifySurvey(Survey survey) {
		int result = mStore.updateSurvey(survey, session);
		return result;
	}

	@Override
	public User printOneUser(String userId) {
		User user = mStore.selectOneUser(userId, session);
		return user;
	}

	@Override
	public int modifyInfo(User user) {
		int result = mStore.updateInfo(user, session);
		return result;
	}

	@Override
	public String findUserByNickname(String userNickname) {
		User user = mStore.getUserByNickname(userNickname, session);
		if(user != null) {
			return "exist";
		} else {
			return "itsOk";	
		}
	}

	@Override
	public int getTotalBCount(String userId) {
		int totalBCount = mStore.selectTotalBCount(session, userId);
		return totalBCount;
	}

	@Override
	public List<Comm> printMyBoard(int currentPage, int boardLimit, String userId) {
		List<Comm> cList = mStore.selectMyBoard(session, currentPage, boardLimit, userId);
		return cList;
	}

	@Override
	public List<Order> printMyOrder(int currentPage, int orderLimit, String userId) {
		List<Order> oList = mStore.selectMyOrder(session,currentPage, orderLimit, userId);
		return oList;
	}

	@Override
	public int deleteUser(String userEmail, String textEmail) {
		int result = mStore.deleteUser(session, userEmail, textEmail);
		return result;
	}

	@Override
	public int getTotalOCount(String userId) {
		int totalOCount = mStore.selectTotalOCount(session, userId);
		return totalOCount;
	}

}
