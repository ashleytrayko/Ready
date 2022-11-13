package com.kh.ready.user.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ready.book.domain.Book;
import com.kh.ready.community.domain.Comm;
import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.domain.Notice;
import com.kh.ready.user.domain.User;
import com.kh.ready.user.repository.AdminRepository;

@Repository
public class AdminRepositoryImpl implements AdminRepository{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertBanner(Banner banner) {
		int result = session.insert("AdminMapper.insertBanner",banner);
		return result;
	}

	@Override
	public int deleteBanner(Integer bannerFrom) {
		int result = session.delete("AdminMapper.deleteBanner", bannerFrom);
		return result;
	}

	@Override
	public List<Banner> selectAllBanner() {
		List<Banner> bannerList = session.selectList("AdminMapper.selectAllBanner");
		return bannerList;
	}

	@Override
	public int insertNotice(Notice notice) {
		int result = session.insert("AdminMapper.insertNotice", notice);
		return result;
	}
	
	@Override
	public int selectTotalCount(HashMap<String, String> paramMap) {
		int result = session.selectOne("AdminMapper.selectNoticeCount", paramMap);
		return result;
	}

	@Override
	public List<Notice> selectAllNotice(int currentPage, int noticeLimit) {
		int offset = (currentPage - 1) * noticeLimit;
		RowBounds rowBounds = new RowBounds(offset, noticeLimit);
		List<Notice> noticeList =  session.selectList("AdminMapper.selectAllNotice", null, rowBounds);
		return noticeList;
	}

	@Override
	public int deleteNotice(Integer noticeNumber) {
		int result = session.delete("AdminMapper.deleteNotice", noticeNumber);
		return result;
	}

	@Override
	public Notice selectNoticeByNumber(Integer noticeNumber) {
		Notice notice = session.selectOne("AdminMapper.selectNoticeByNumber", noticeNumber);
		return notice;
	}
	
	@Override
	public Notice selectRecentNotice() {
		Notice notice = session.selectOne("AdminMapper.selectRecentNotice");
		return notice;
	}

	@Override
	public int updateNotice(Notice notice) {
		int result = session.update("AdminMapper.updateNotice", notice);
		return result;
	}
	
	@Override
	public int selectReportCount() {
		int reportCount = session.selectOne("AdminMapper.selectReportCount");
		return reportCount;
	}
	
	@Override
	public int selectCompleteCount() {
		int completeCount = session.selectOne("AdminMapper.selectCompleteCount");
		return completeCount;
	}
	
	@Override
	public List<Comm> selectAllReport(int currentPage, int boardLimit) {
		int offset = (currentPage - 1) * boardLimit;
		RowBounds rowBounds = new RowBounds(offset, boardLimit);
		List<Comm> reportList = session.selectList("AdminMapper.selectAllReport", null, rowBounds);
		return reportList;
	}
	
	@Override
	public List<Comm> selectAllComplete() {
		List<Comm> completeList = session.selectList("AdminMapper.selectAllComplete");
		return completeList;
	}

	@Override
	public Comm selectOneReport(Integer boardNo) {
		Comm reportedComm = session.selectOne("AdminMapper.selectOneReport", boardNo);
		return reportedComm;
	}

	@Override
	public int updateReportedComm(Integer boardNo) {
		int result = session.update("AdminMapper.updateReportComm", boardNo);
		return result;
	}
	
	@Override
	public int deleteReportedComm(Integer boardNo) {
		int result = session.delete("AdminMapper.deleteReportedComm", boardNo);
		return result;
	}

	@Override
	public int updateBadUser(String userId) {
		int result = session.update("UserMapper.updateBadUser", userId);
		return result;
	}

	@Override
	public int kickOutUser(String userId) {
		int result = session.update("UserMapper.kickOutUser", userId);
		return result;
	}

	@Override
	public int updateProduct(Book book) {
		int result = session.update("AdminMapper.updateProduct",book);
		return result;
	}

	@Override
	public int deleteBook(Integer bookNo) {
		int result = session.delete("AdminMapper.deleteBookByNo", bookNo);
		return result;
	}

	@Override
	public int updateSuspendResultInComm(Integer boardNo) {
		int commResult = session.update("AdminMapper.updateSuspendResultInComm", boardNo);
		return commResult;
	}

	@Override
	public int updateKickoutResultInComm(Integer boardNo) {
		int commResult = session.update("AdminMapper.updateKickoutResultInComm", boardNo);
		return commResult;
	}

	@Override
	public int selectQuestionCount() {
		int questionCount = session.selectOne("AdminMapper.selectQuestionCount");
		return questionCount;
	}

	@Override
	public int selectAnsweredCount() {
		int answeredCount = session.selectOne("AdminMapper.selectAnsweredCount");
		return answeredCount;
	}













}
