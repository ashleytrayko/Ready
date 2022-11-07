package com.kh.ready.user.service;

import java.security.Principal;
import java.util.List;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.domain.Notice;

public interface AdminService {
	
	// 배너 삽입
	public int registerBanner(Banner banner);
	
	// 배너 삭제
	public int removeBanner(Integer bannerFrom);
	
	// 배너 전체 조회 
	public List<Banner> showAllBanner();
	
	// 공지 등록
	public String registerNotice(Notice notice, Principal principal);

	// 공지 삭제
	public int removeNotice(Integer noticeNumber);

	// 공지 전체 조회
	public List<Notice> showAllNotice();
	
	// 공지 1개 조회
	public Notice selectNoticeByNumber(Integer noticeNumber);
	
	// 공지 수정
	public String modifyNotice(Notice notice);
	
	// 신고글 전체 조회
	public List<Comm> showAllReport();
	
	// 처벌등록 
	public String punishUser(String punishment, String userNickname);

}
