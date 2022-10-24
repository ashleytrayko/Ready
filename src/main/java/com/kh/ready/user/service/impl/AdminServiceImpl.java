package com.kh.ready.user.service.impl;

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
		System.out.println(result);
		return result;
	}


}
