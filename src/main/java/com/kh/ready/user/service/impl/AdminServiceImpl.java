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

		
	@Override
	public int registerBanner(Banner banner) {
		int result = adminRepository.insertBanner(banner);
		return result;
	}


	@Override
	public int removeBanner(Integer bannerNumber) {
		int result = adminRepository.deleteBanner(bannerNumber);
		return result;
	}


	@Override
	public List<Banner> showAllBanner() {
		List<Banner> bannerList = adminRepository.selectAllBanner();
		return bannerList;
	}


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

	@Override
	public int removeNotice(Integer noticeNumber) {
		int result = adminRepository.deleteNotice(noticeNumber);
		return result;
	}

	@Override
	public List<Notice> showAllNotice() {
		List<Notice> noticeList = adminRepository.selectAllNotice();
		return noticeList;
	}


	@Override
	public Notice selectNoticeByNumber(Integer noticeNumber) {
		Notice notice = adminRepository.selectNoticeByNumber(noticeNumber);
		return notice;
	}


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
