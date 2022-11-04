package com.kh.ready.user.service.impl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.domain.Notice;
import com.kh.ready.user.repository.AdminRepository;
import com.kh.ready.user.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepository;

	// 배너 등록
	@Override
	public int registerBanner(Banner banner) {
		int result = adminRepository.insertBanner(banner);
		return result;
	}

	// 배너 삭제
	@Override
	public int removeBanner(Integer bannerFrom) {
		int result = adminRepository.deleteBanner(bannerFrom);
		return result;
	}

	
	// 배너 선택
	@Override
	public List<Banner> showAllBanner() {
		List<Banner> bannerList = adminRepository.selectAllBanner();
		return bannerList;
	}

	// 공지등록
	@Override
	public String registerNotice(Notice notice, Principal principal) {
		notice.setNoticeWriter(principal.getName());
		int result = adminRepository.insertNotice(notice);
		
		if(result > 0) {
			return "insert success";
		}else {
			return "insert fail";
		}
	}
	
	// 공지삭제
	@Override
	public int removeNotice(Integer noticeNumber) {
		int result = adminRepository.deleteNotice(noticeNumber);
		return result;
	}
	
	// 공지 전체보기
	@Override
	public List<Notice> showAllNotice() {
		List<Notice> noticeList = adminRepository.selectAllNotice();
		return noticeList;
	}

	// 공지 상세보기
	@Override
	public Notice selectNoticeByNumber(Integer noticeNumber) {
		Notice notice = adminRepository.selectNoticeByNumber(noticeNumber);
		return notice;
	}

	 // 공지 수정
	@Override
	public String modifyNotice(Notice notice) {
		int result = adminRepository.updateNotice(notice);
		if(result > 0) {
			return "update success";
		}else {
			return "update fail";
		}
	}





}
