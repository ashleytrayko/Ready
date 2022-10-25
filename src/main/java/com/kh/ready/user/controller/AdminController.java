package com.kh.ready.user.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.service.BookService;
import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.domain.Notice;
import com.kh.ready.user.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BookService bookService;
	
	/**
	 *  admin 화면 요청
	 */
	// admin 화면
	@GetMapping("/admin")
	public String adminTest() {
		return "/admin/adminMenu";
	}
	
	// admin - 공지관리
	@GetMapping("/admin-notice")
	public String noticeList(Model model) {
		List<Notice> noticeList = adminService.showAllNotice();
		model.addAttribute("noticeList", noticeList);
		return "/admin/adminNotice";
	}
	
	// admin - 공지작성폼
	@GetMapping("/admin-noticeForm")
	public String noticeForm() {
		return "/admin/adminNoticeWriteForm";
	}
	
	// 공지사항 수정화면
	@GetMapping("/modifyNoticeForm")
	public String modifyNotice(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		Notice notice = adminService.selectNoticeByNumber(noticeNumber);
		model.addAttribute("notice", notice);
		return "/admin/adminNoticeModifyForm"; 
	}
	
	// admin - 공지 상세보기
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		Notice notice = adminService.selectNoticeByNumber(noticeNumber);
		model.addAttribute("notice", notice);
		return "/admin/adminNoticeDetail";
	}
	
	
	// admin - 배너관리
	@GetMapping("/admin-banner")
	public String bannerList(Model model) {
		
		// 배너 전체조회
		List<Banner> bannerList = adminService.showAllBanner();
		model.addAttribute("bannerList", bannerList);
		return "/admin/adminBanner";
	}
	
	// admin - 주문관리
	@GetMapping("/admin-order")
	public String orderList() {
		return "/admin/adminOrder";
	}
	
	// admin - 상품관리
	@GetMapping("/admin-product")
	public String productList(Model model) {
		
		// 상품 전체 조회
		List<Book> bookList = bookService.printAllBook();
		model.addAttribute("bookList", bookList);
		return "/admin/adminProduct";
	}
	
	// admin - 상품 등록 폼
	@GetMapping("/admin-productForm")
	public String productForm() {
		return "/admin/adminProductRegistForm";
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
	
	/**
	 * 배너 관
	 */
	
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
	
	// 배너 삭제
	@GetMapping("/removeBanner")
	public String removeBanner(@RequestParam("bannerNumber") Integer bannerNumber) {
		adminService.removeBanner(bannerNumber);
		return "/admin/adminBanner";
	}
	
	// 공지사항 등록
	@PostMapping("/postNotice")
	public String registerNotice(@ModelAttribute Notice notice, Principal principal) {
		String result = adminService.registerNotice(notice, principal);
		System.out.println(result);
		return "/admin/adminNotice";
	}
	
	// 공지사항 삭제
	@GetMapping("/removeNotice")
	public String removeNotice(@RequestParam("noticeNumber") Integer noticeNumber) {
		adminService.removeNotice(noticeNumber);
		return "/admin/adminNotice";
	}
	
	// 공지사항 수정
	@PostMapping("/modifyNotice")
	public String removeNotice(@ModelAttribute Notice notice) {
		String result = adminService.modifyNotice(notice);
		System.out.println(result);
		return "/admin/adminNotice";
	}
	
	// 상품등록
	@PostMapping("/registerProduct")
	public String registerProduct(Book book) {
		int result = bookService.registerBook(book);
		// 파일 관련 코드 추후 추가
		if(result > 0) {
			return "/admin/adminProduct";
		}else {
			return "/admin/adminProduct";
		}
		
	}
	
	// 상품삭제
	@PostMapping("/deleteProduct")
	public String removeProduct(@RequestParam("bookNo") Integer bookNo) {
		int result = bookService.removeBook(bookNo);
		return "/admin/adminProduct";
	}
	
	
	

	
	
}
