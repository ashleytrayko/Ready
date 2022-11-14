package com.kh.ready.mypage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.store.MypageStore;
import com.kh.ready.order.domain.Order;
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

	@Override
	public int selectTotalBCount(SqlSessionTemplate session, String userId) {
		int totalBCount = session.selectOne("MypageMapper.selectTotalBCount", userId);
		return totalBCount;
	}

	@Override
	public List<Comm> selectMyBoard(SqlSessionTemplate session, int currentPage, int boardLimit, String userId) {
		int offset = (currentPage - 1) * boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Comm> cList = session.selectList("MypageMapper.selectMyBoard", userId, rowBounds);
		return cList;
	}

	@Override
	public List<Order> selectMyOrder(SqlSessionTemplate session, int currentPage, int orderLimit, String userId) {
		int offset = (currentPage - 1) * orderLimit;
		RowBounds rowBounds = new RowBounds(offset, orderLimit);
		List<Order> oList = session.selectList("MypageMapper.selectMyOrder", userId, rowBounds);
		return oList;
	}

	@Override
	public int deleteUser(SqlSessionTemplate session, String userEmail, String textEmail) {
		HashMap<String, String> paramMap= new HashMap<String, String>();
		paramMap.put("userEmail", userEmail);
		paramMap.put("textEmail", textEmail);
		int result = session.update("MypageMapper.deleteUser", paramMap);
		return result;
	}

	@Override
	public int selectTotalOCount(SqlSessionTemplate session, String userId) {
		int totalOCount = session.selectOne("MypageMapper.selectTotalOCount", userId);
		return totalOCount;
	}

}
