package com.kh.ready.user.service;

import java.security.Principal;
import java.util.List;

import com.kh.ready.book.domain.Book;
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

	// 페이징
	public int getTotalCount(String string, String string2);

	// 공지 전체 조회
	public List<Notice> showAllNotice(int currentPage, int noticeLimit);
	
	// 공지 1개 조회
	public Notice selectNoticeByNumber(Integer noticeNumber);
	
	// 메인페이지 공지 뿌리기
	public Notice selectRecentNotice();
	
	// 공지 수정
	public String modifyNotice(Notice notice);
	
	// 신고글 전체 조회
	public List<Comm> showAllReport(int currentPage, int boardLimit);
	
	// 신고글 상세 조회
	public Comm showReportDetail(Integer boardNo);
	
	// 신고글 복구
	public String recoverComm(Integer boardNo);
	
	// 신고글 삭제
	public String terminateComm(Integer boardNo);

	// 처벌등록 
	public String punishUser(String punishment, String userId);
	
	// 상품 변경
	public String modifyProduct(Book book);
	
	// 상품 삭제
	public int removeBook(Integer bookNo);





}
