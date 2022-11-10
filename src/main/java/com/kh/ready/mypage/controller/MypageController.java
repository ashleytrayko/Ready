package com.kh.ready.mypage.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.mypage.domain.Survey;
import com.kh.ready.mypage.service.MypageService;
import com.kh.ready.order.domain.Order;
import com.kh.ready.user.domain.User;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService mService;
	
	@Lazy
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private  AuthenticationManager authenticationManager;
	
	//설문조사 페이지
	@RequestMapping(value="mypage/surveyMain.kh", method=RequestMethod.GET)
	public ModelAndView showSurveyPage(ModelAndView mv, Principal principal) {
		try {
			String userId = principal.getName();
			Survey survey = mService.printMySurvey(userId);
			mv.addObject("userId", userId);
			mv.addObject("survey", survey);
			mv.setViewName("mypage/surveyMain");		
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//설문지 등록
	@RequestMapping(value="mypage/registSurvey.kh", method=RequestMethod.POST)
	public ModelAndView registSurvey(ModelAndView mv, @ModelAttribute Survey survey, Principal principal) {
		try {
			String userId = principal.getName();
			survey.setUserId(userId);
			int result = mService.registSurvey(survey);
			mv.setViewName("mypage/main");
		} catch(Exception e) {
			mv.addObject("msg", "설문조사 등록실패");
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//설문지 수정 페이지
	@RequestMapping(value="mypage/modifyForm.kh", method=RequestMethod.GET)
	public ModelAndView showModifySurvey(ModelAndView mv, Principal principal) {
		try {
			String userId = principal.getName();
			Survey survey = mService.printMySurvey(userId);
			mv.addObject("survey", survey);
			mv.setViewName("mypage/modifySurvey");
		} catch(Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	//설문지 수정
	@RequestMapping(value="mypage/modifySurvey.kh", method=RequestMethod.POST)
	public ModelAndView modifySurvey(ModelAndView mv,@ModelAttribute Survey survey) {
		int result = mService.modifySurvey(survey);
		if(result > 0) {
			mv.setViewName("redirect:/mypage/surveyMain.kh");
		} else {
			mv.addObject("msg", "수정오류");
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	//내 정보 조회
	@RequestMapping(value="mypage/myInfo.kh", method=RequestMethod.GET)
	public ModelAndView showMyInfo(ModelAndView mv, Principal principal) {
		String userId = principal.getName();
		User uOne = mService.printOneUser(userId);
		mv.addObject("user", uOne);
		mv.setViewName("mypage/myInfo");
		return mv;
	}
	
	//회원 정보 수정
	@Transactional
	@RequestMapping(value="mypage/modifyInfo.kh", method=RequestMethod.POST)
	public ModelAndView modifyInfo(ModelAndView mv,@ModelAttribute User user) {
		String encodedPassword = encoder.encode(user.getUserPassword());
		user.setUserPassword(encodedPassword);
		int result = mService.modifyInfo(user);
		if(result > 0) {
//			Authentication authentiction = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserId(), user.getUserPassword()));
//			SecurityContextHolder.getContext().setAuthentication(authentiction);
			mv.setViewName("mypage/myInfo");
		} else {
			mv.addObject("msg", "수정오류");
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	//회원 탈퇴 페이지 이동
	@RequestMapping(value="mypage/deleteForm.kh", method=RequestMethod.GET)
	public String deleteView() {
		return "mypage/deleteView";
	}
	
	//회원 탈퇴
	@RequestMapping(value="/mypage/deleteUser.kh", method=RequestMethod.POST)
	public ModelAndView deleteUser(ModelAndView mv, @ModelAttribute User user, @RequestParam("textEmail") String textEmail) {
		String userEmail = user.getUserEmail();
		int result = mService.deleteUser(userEmail, textEmail);
		if(!userEmail.equals(textEmail)) {
			mv.addObject("msg","이메일이 일치하지 않습니다.");
			mv.setViewName("mypage/deleteView");
			return mv;
		}
		if (result > 0) {
			mv.setViewName("redirect:/logout");
		}
		return mv;
	}
	
	//내가 쓴 글 조회
	@RequestMapping(value="mypage/myBoard.kh", method=RequestMethod.GET)
	public ModelAndView printMyBoard(ModelAndView mv,
			@RequestParam(value="page", required=false) Integer page,
			Principal principal) {
		String userId = principal.getName();
		int currentPage = (page != null)? page : 1;
		int totalBCount = mService.getTotalBCount(userId);
		int boardLimit = 10;
		int naviLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		maxPage = (int) ((double) totalBCount / boardLimit + 0.9);
		startNavi = ((int) ((double) currentPage / naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		List<Comm> cList = mService.printMyBoard(currentPage, boardLimit, userId);
		if (!cList.isEmpty()) {
			mv.addObject("urlVal", "myBoard");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("/mypage/myBoard");
		return mv;
	}
	
	// 닉네임 중복확인
		@ResponseBody
		@GetMapping("/checkNickname2")
		public String checkNickname(@RequestParam("userNickname") String userNickname) {
			String result = mService.findUserByNickname(userNickname);
			if(result.equals("itsOk")) {
				return "itsOk";
			}else {
				return "exist";
			}
		}
		
		//내 주문내역 리스트
		@RequestMapping(value="mypage/myOrder.kh", method=RequestMethod.GET)
		public ModelAndView printMyOrder(ModelAndView mv, Principal principal) {
			try {				
				String userId = principal.getName();
				List<Order> oList = mService.printMyOrder(userId);
				if(!oList.isEmpty()) {
					mv.addObject("oList", oList);
				}
				mv.setViewName("mypage/myOrder");
			} catch (Exception e) {
				e.printStackTrace();
				mv.setViewName("/main/errorPage");
			}
			return mv;
		}
}
