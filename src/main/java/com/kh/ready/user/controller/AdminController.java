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
import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.service.CommService;
import com.kh.ready.question.domain.Question;
import com.kh.ready.user.domain.Banner;
import com.kh.ready.user.domain.Notice;
import com.kh.ready.user.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CommService commService;
	
	/**
	 *  admin 화면 요청
	 */
	// admin 메인 메뉴
	@GetMapping("/admin")
	public String adminTest(Model model) {
		return "/admin/adminMenu";
	}
	
	/**
	 * 공지사항 관리
	 */
	
	// admin - 공지관리
	@GetMapping("/admin/admin-notice")
	public String noticeList(@RequestParam(value="page", required=false) Integer page, Model model) {
		//페이징
		int currentPage = (page != null) ? page : 1;
		int totalCount = adminService.getTotalCount("", "");
		int noticeLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int)((double)totalCount/noticeLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9)-1) * naviLimit +1;
		endNavi = startNavi + naviLimit - 1;
		
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		
		List<Notice> noticeList = adminService.showAllNotice(currentPage, noticeLimit);
		
		if (!noticeList.isEmpty()) {
			model.addAttribute("urlVal","admin-notice");
			model.addAttribute("maxPage",maxPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startNavi", startNavi);
			model.addAttribute("endNavi", endNavi);
			model.addAttribute("noticeList", noticeList);
		}
		
		return "/admin/notice/adminNotice";
	}
	
	// admin - 공지작성폼
	@GetMapping("/admin/admin-noticeForm")
	public String noticeForm() {
		return "/admin/notice/adminNoticeWriteForm";
	}
	
	// 공지사항 수정화면
	@GetMapping("/admin/modifyNoticeForm")
	public String modifyNotice(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		Notice notice = adminService.selectNoticeByNumber(noticeNumber);
		model.addAttribute("notice", notice);
		return "/admin/notice/adminNoticeModifyForm"; 
	}
	
	// 공지사항 등록
	@PostMapping("/admin/postNotice")
	public String registerNotice(@ModelAttribute Notice notice, Principal principal, Model model) {
		String result = adminService.registerNotice(notice, principal);
		return "redirect:/admin/admin-notice";
	}

	// 공지사항 삭제
	@GetMapping("/admin/removeNotice")
	public String removeNotice(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		adminService.removeNotice(noticeNumber);
		return "redirect:/admin/admin-notice";
	}

	// 공지사항 수정
	@PostMapping("/admin/modifyNotice")
	public String modifyNotice(@ModelAttribute Notice notice, Model model) {
		String result = adminService.modifyNotice(notice);
		return "redirect:/admin/admin-notice";
	}

	// admin - 공지 상세보기
	@GetMapping("/admin/noticeDetail")
	public String noticeDetail(@RequestParam("noticeNumber") Integer noticeNumber, Model model) {
		Notice notice = adminService.selectNoticeByNumber(noticeNumber);
		model.addAttribute("notice", notice);
		return "/admin/notice/adminNoticeDetail";
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
		return "/admin/banner/adminBanner";
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
		return "/admin/banner/adminBanner";
	}

	// 배너 삭제
	@GetMapping("/admin/removeBanner")
	public String removeBanner(@RequestParam("bannerFrom") Integer bannerFrom,
								Model model) {
		adminService.removeBanner(bannerFrom);
		List<Banner> bannerList = adminService.showAllBanner();
		model.addAttribute("bannerList", bannerList);
		return "/admin/banner/adminBanner";
	}

	/**
	 * 주문관리
	 */
	// admin - 주문관리
	@GetMapping("/admin/admin-order")
	public String orderList() {
		return "/admin/order/adminOrder";
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
		return "/admin/product/adminProduct";
	}
	
	// admin - 상품 등록 폼
	@GetMapping("/admin/admin-productForm")
	public String productForm() {
		return "/admin/product/adminProductRegistForm";
	}
	
	// 상품등록 -> 수정
	@PostMapping("/admin/registerProduct")
	public String registerProduct(Book book) {
		int result = bookService.registerBook(book);
		// 파일 관련 코드 추후 추가
		if(result > 0) {
			return "/admin/product/adminProduct";
		}else {
			return "/admin/product/adminProduct";
		}
		
	}

	// 상품삭제
	@PostMapping("/admin/deleteProduct")
	public String removeProduct(@RequestParam("bookNo") Integer bookNo) {
		int result = bookService.removeBook(bookNo);
		return "/admin/product/adminProduct";
	}
	
	/**
	 * QnA 관리
	 */


	
	// 삭제는 고민..
	/**
	 * 신고관리
	 */
	
	// admin - 신고관리 -> 조치 했는지 표시 고민..
	@GetMapping("/admin/admin-report")
	public String reportList(@RequestParam(value="page", required=false) Integer page,
							Model model) {
		
		// admin- 신고관리 - 커뮤니티 - 신고게시글 리스트 불러오기
		// 일단은 충돌우려로 adminService에씀
		
		///////////////////////////////////////////////////////////////////////// -> 일단은 전체 불러오기했음 나중에 쿼리 변경해서 연결
		int currentPage = (page != null) ? page : 1;
		int totalCount = commService.getTotalCount("", "");
		int boardLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		
		// 23/5 = 4.8 + 0.9 = 5(.7)
		maxPage = (int) ((double) totalCount / boardLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
		endNavi = maxPage;
		}
		
		List<Comm> reportList = commService.printAllBoard(currentPage, boardLimit);
		if (!reportList.isEmpty()) {
			model.addAttribute("urlVal","admin-report");
			model.addAttribute("maxPage",maxPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startNavi", startNavi);
			model.addAttribute("endNavi", endNavi);
			model.addAttribute("reportList", reportList);
		}
		
		return "/admin/report/adminReport";
	}
	
	// 신고 내용 보기 
	@GetMapping("/admin/reportDetail")
	public String reportDetail(@RequestParam("boardNo") Integer boardNo, Model model) {
		Comm comm = commService.printOneByNo(boardNo);
		model.addAttribute("comm", comm);
		return "/admin/report/adminReportDetail";
	}
	
	// 처벌페이지
	@GetMapping("/admin/punishPage")
	public String punishPage(Model model, @RequestParam("commWriter") String commWriter) {
		model.addAttribute("commWriter", commWriter);
		return "/admin/report/adminJudgementPage";
	}
	
	// 유저에게 처벌 내리기 -> 처벌 페이지 만들기
	@PostMapping("/admin/punish")
	public String punishUser(@RequestParam("punishment") String punishment,
							@RequestParam("userNickname") String userNickname) {
		// 처벌의 내용(일단은 커뮤니티 접근금지or글쓰기금지//회원로그인금or탈퇴)이  -> 시큐리티 기능을 이용하면 좋을거같음 
		// 컨트롤러로 넘어옴 
		// 서비스로 보냄 
		
		String result = adminService.punishUser(punishment, userNickname);
		
		// 이후 상황은 추가하던가 함 
	
		return "redirect:/admin/reportDetail";
	}
	
	 
	
	
	

	
	
}
