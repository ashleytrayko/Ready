package com.kh.ready.user.repository;

import java.util.List;

import com.kh.ready.user.domain.Banner;

public interface AdminRepository {

	public int insertBanner(Banner banner);
	
	public int deleteBanner(Integer bannerNumber);
	
	public List<Banner> selectAllBanner();
}
