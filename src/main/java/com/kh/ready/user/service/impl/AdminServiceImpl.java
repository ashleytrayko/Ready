package com.kh.ready.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.user.domain.Banner;
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


}
