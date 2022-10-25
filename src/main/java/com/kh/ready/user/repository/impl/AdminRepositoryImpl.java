package com.kh.ready.user.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.domain.Notice;
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
	public int deleteBanner(Integer bannerNumber) {
		int result = session.delete("AdminMapper.deleteBanner", bannerNumber);
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
	public List<Notice> selectAllNotice() {
		List<Notice> noticeList =  session.selectList("AdminMapper.selectAllNotice");
		return noticeList;
	}

	@Override
	public int deleteNotice(Integer noticeNumber) {
		int result = session.delete("AdminMapper.deleteNotice");
		return result;
	}

	@Override
	public Notice selectNoticeByNumber(Integer noticeNumber) {
		Notice notice = session.selectOne("AdminMapper.selectNoticeByNumber", noticeNumber);
		return notice;
	}

	@Override
	public int updateNotice(Notice notice) {
		int result = session.update("AdminMapper.updateNotice", notice);
		return result;
	}

}