package com.kh.ready.mypage.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.order.domain.Order;
import com.kh.ready.user.domain.User;

public interface MypageStore {

	int insertSurvey(Survey survey, SqlSessionTemplate session);

	Survey selectMySurvey(String userId, SqlSessionTemplate session);

	int updateSurvey(Survey survey, SqlSessionTemplate session);

	User selectOneUser(String userId, SqlSessionTemplate session);

	int updateInfo(User user, SqlSessionTemplate session);

	User getUserByNickname(String userNickname, SqlSessionTemplate session);

	int selectTotalBCount(SqlSessionTemplate session, String userId);

	List<Comm> selectMyBoard(SqlSessionTemplate session, int currentPage, int boardLimit, String userId);

	List<Order> selectMyOrder(SqlSessionTemplate session, String userId);

	int deleteUser(SqlSessionTemplate session, String userEmail, String textEmail);

}
