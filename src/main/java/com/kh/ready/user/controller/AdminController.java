package com.kh.ready.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 *  admin 화면 요청
	 */
	// admin 화면
	@GetMapping("/admin")
	public String adminTest() {
		return "/admin/adminTest";
	}
	
	// admin - 공지관리
	@GetMapping("/admin-notice")
	public String noticeList() {
		return "/admin/adminNotice";
	}
	
	// admin - 배너관리
	@GetMapping("/admin-banner")
	public String bannerList() {
		return "/admin/adminBanner";
	}
	
	// admin - 주문관리
	@GetMapping("/admin-order")
	public String orderList() {
		return "/admin/adminOrder";
	}
	
	// admin - 상품관리
	@GetMapping("/admin-product")
	public String productList() {
		return "/admin/adminProduct";
	}
	
	// admin - QnA 관리
	@GetMapping("/admin-qna")
	public String qnaList() {
		return "/admin/adminQna";
	}
	
	// admin - 신고관리
	@GetMapping("/admin-report")
	public String reportList() {
		return "/admin/adminReport";
	}
	
	// 배너 등록
	@PostMapping("/registerBanner")
	public String registerBanner(@RequestParam(value="bannerImage",required = false) MultipartFile bannerImage,
									HttpServletRequest request,
									@ModelAttribute Banner banner) {
		try {
			String bannerName = bannerImage.getOriginalFilename();
			//banner.setBannerName(bannerImage.getOriginalFilename());
			if(!bannerImage.getOriginalFilename().equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\banner";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String bannerRename = sdf.format(new Date(System.currentTimeMillis()))+"."+bannerName.substring(bannerName.lastIndexOf(".")+1);
				//banner.setBannerRename(sdf.format(new Date(System.currentTimeMillis()))+"."+banner.getBannerName().substring(banner.getBannerName().lastIndexOf(".")+1));
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				bannerImage.transferTo(new File(savePath+"\\"+bannerName));
				
				String bannerPath = savePath + "\\" + bannerRename;
				banner.setBannerName(bannerName);
				banner.setBannerRename(bannerRename);
				banner.setBannerPath(bannerPath);
			}
			System.out.println(banner.toString());
			int result = adminService.registerBanner(banner);
			System.out.println(result);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return "/admin/adminBanner";
	}
}
