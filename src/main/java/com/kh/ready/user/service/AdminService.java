package com.kh.ready.user.service;

import java.util.List;

import com.kh.ready.user.domain.Banner;

public interface AdminService {
	
	// 배너 삽입
	public int registerBanner(Banner banner);
	
	// 배너 삭제
	public int removeBanner(Integer bannerNumber);
	
	// 배너 전체 조회 
	public List<Banner> showAllBanner();
}
