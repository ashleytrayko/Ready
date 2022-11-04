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
	// admin 메인 메뉴
	@GetMapping("/admin")
	public String adminTest() {
		return "/admin/adminMenu";
	}
	
	/**
	 * 공지사항 관리
	 */
	
	// admin - 공지관리
	@GetMapping("/admin/admin-notice")
	public String noticeList(Model model) {
		List<Notice> noticeList = adminService.showAllNotice();
		model.addAttribute("noticeList", noticeList);
		return "/admin/adminNotice";
	}
	
	// admin - 공지작성폼
	@GetMapping("/admin/admin-noticeForm")
	public String noticeForm() {
		return "/admin/adminNoticeWriteForm";
	}
	
	// 공지사항 수정화면
	@GetMapping("/admin/modifyNoticeForm")
	public String modifyNotice(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		Notice notice = adminService.selectNoticeByNumber(noticeNumber);
		model.addAttribute("notice", notice);
		return "/admin/adminNoticeModifyForm"; 
	}
	
	// 공지사항 등록
	@PostMapping("/admin/postNotice")
	public String registerNotice(@ModelAttribute Notice notice, Principal principal, Model model) {
		String result = adminService.registerNotice(notice, principal);
		List<Notice> noticeList = adminService.showAllNotice();
		model.addAttribute("noticeList", noticeList);
		return "/admin/adminNotice";
	}

	// 공지사항 삭제
	@GetMapping("/admin/removeNotice")
	public String removeNotice(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		adminService.removeNotice(noticeNumber);
		List<Notice> noticeList = adminService.showAllNotice();
		model.addAttribute("noticeList", noticeList);
		return "/admin/adminNotice";
	}

	// 공지사항 수정
	@PostMapping("/admin/modifyNotice")
	public String modifyNotice(@ModelAttribute Notice notice, Model model) {
		String result = adminService.modifyNotice(notice);
		List<Notice> noticeList = adminService.showAllNotice();
		model.addAttribute("noticeList", noticeList);
		return "/admin/adminNotice";
	}

	// admin - 공지 상세보기
	@GetMapping("/admin/noticeDetail")
	public String noticeDetail(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		Notice notice = adminService.selectNoticeByNumber(noticeNumber);
		model.addAttribute("notice", notice);
		return "/admin/adminNoticeDetail";
	}
	
	/**
	 * 배너관리
	 */
	// admin - 배너관리
	@GetMapping("/admin/admin-banner")
	public String bannerList(Model model) {
		
		// 배너 전체조회
		List<Banner> bannerList = adminService.showAllBanner();
		model.addAttribute("bannerList", bannerList);
		return "/admin/adminBanner";
	}

	// 배너 등록
	@PostMapping("/admin/registerBanner")
	public String registerBanner(@RequestParam(value="bannerImage",required = false) MultipartFile bannerImage,
									HttpServletRequest request,
									@ModelAttribute Banner banner,
									Model model) {
		try {
			String bannerName = bannerImage.getOriginalFilename();
			//banner.setBannerName(bannerImage.getOriginalFilename());
			if(!bannerImage.getOriginalFilename().equals("")) {
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savePath = root + "\\images\\banner";
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String bannerRename = sdf.format(new Date(System.currentTimeMillis()))+"."+bannerName.substring(bannerName.lastIndexOf(".")+1);
				//banner.setBannerRename(sdf.format(new Date(System.currentTimeMillis()))+"."+banner.getBannerName().substring(banner.getBannerName().lastIndexOf(".")+1));
				File file = new File(savePath);
				if(!file.exists()) {
					file.mkdir();
				}
				bannerImage.transferTo(new File(savePath+"\\"+bannerRename));
				
				String bannerPath = savePath + "\\" + bannerRename;
				banner.setBannerName(bannerName);
				banner.setBannerRename(bannerRename);
				banner.setBannerPath(bannerPath);
			}
			System.out.println(banner.toString());
			int result = adminService.registerBanner(banner);
		}catch (IOException e) {
			e.printStackTrace();
		}
		List<Banner> bannerList = adminService.showAllBanner();
		model.addAttribute("bannerList", bannerList);
		return "/admin/adminBanner";
	}

	// 배너 삭제
	@GetMapping("/admin/removeBanner")
	public String removeBanner(@RequestParam("bannerFrom") Integer bannerFrom,
								Model model) {
		adminService.removeBanner(bannerFrom);
		List<Banner> bannerList = adminService.showAllBanner();
		model.addAttribute("bannerList", bannerList);
		return "/admin/adminBanner";
	}

	/**
	 * 주문관리
	 */
	// admin - 주문관리
	@GetMapping("/admin/admin-order")
	public String orderList() {
		return "/admin/adminOrder";
	}
	
	/**
	 * 상품관리
	 */
	
	// admin - 상품관리
	@GetMapping("/admin/admin-product")
	public String productList(Model model, @RequestParam(value="page", required=false) Integer page) {
		//페이징
		int currentPage = (page != null) ? page : 1;
		int totalCount = bookService.getTotalCount("", "");
		int bookLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/bookLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit +1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		
		// 상품 전체 조회
		List<Book> bookList = bookService.printAllBook(currentPage, bookLimit);
		if(!bookList.isEmpty()) {
			model.addAttribute("urlVal", "admin-product");
			model.addAttribute("currentPage",currentPage);
			model.addAttribute("maxPage", maxPage);
			model.addAttribute("startNavi", startNavi);
			model.addAttribute("endNavi", endNavi);
			model.addAttribute("bookList", bookList);
		}
		return "/admin/adminProduct";
	}
	
	// admin - 상품 등록 폼
	@GetMapping("/admin/admin-productForm")
	public String productForm() {
		return "/admin/adminProductRegistForm";
	}
	
	// 상품등록
	@PostMapping("/admin/registerProduct")
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
	@PostMapping("/admin/deleteProduct")
	public String removeProduct(@RequestParam("bookNo") Integer bookNo) {
		int result = bookService.removeBook(bookNo);
		return "/admin/adminProduct";
	}
	
	/**
	 * QnA 관리
	 */

	// admin - QnA 관리
	@GetMapping("/admin/admin-qna")
	public String qnaList() {
		return "/admin/adminQna";
	}
	
	/**
	 * 신고관리
	 */
	
	// admin - 신고관리
	@GetMapping("/admin/admin-report")
	public String reportList() {
		return "/admin/adminReport";
	}
	
	
	

	
	
}
