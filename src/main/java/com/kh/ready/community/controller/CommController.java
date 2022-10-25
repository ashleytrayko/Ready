package com.kh.ready.community.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.domain.CommReply;
import com.kh.ready.community.service.CommService;

@Controller
public class CommController {
	@Autowired private CommService cService;
	
	@RequestMapping(value="/comm/viewWrite.kh", method=RequestMethod.GET)
	public String showBoardWrite() {
		return "comm/boardWriteForm";
	}
	
	/**
	 * 게시글 등록
	 * @param mv
	 * @param comm
	 * @param uploadFile
	 * @param request
	 * @return
	 */
	@RequestMapping(value="comm/register.kh", method=RequestMethod.POST)
	public ModelAndView registerBoard(
			ModelAndView mv
			, @ModelAttribute Comm comm
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, HttpServletRequest request) {
		try {
			int result = cService.registerBoard(comm);
			mv.setViewName("redirect:/comm/list.kh");
		} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("msg", e.getMessage());
				mv.setViewName("main/errorPage");
		}
		return mv;
	} 
	
	/**
	 * 게시글 목록
	 * @param mv
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/comm/list.kh", method=RequestMethod.GET)
	public ModelAndView viewList(
			ModelAndView mv
			, @RequestParam(value="page", required=false) Integer page) {
		/////////////////////////////////////////////////////////////////////////
		int currentPage = (page != null) ? page : 1;
		int totalCount = cService.getTotalCount("", "");
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
		//////////////////////////////////////////////////////////////////////////
		// /board/list.kh?page=${currentPage }
		List<Comm> cList = cService.printAllBoard(currentPage, boardLimit);
		if (!cList.isEmpty()) {
			mv.addObject("urlVal", "list");
			mv.addObject("maxPage", maxPage);
			mv.addObject("currentPage", currentPage);
			mv.addObject("startNavi", startNavi);
			mv.addObject("endNavi", endNavi);
			mv.addObject("cList", cList);
		}
		mv.setViewName("/comm/listView");
		return mv;
	}
	
	/**
	 * 게시글 상세보기
	 * @param mv
	 * @param boardNo
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/comm/detail.kh", method=RequestMethod.GET) 
	public ModelAndView detailView( 
			ModelAndView mv 
			, @RequestParam("boardNo") Integer boardNo 
			, @RequestParam("page") Integer page 
			, HttpSession session) { 
		try {
		Comm comm = cService.printOneByNo(boardNo); 
		List<CommReply> cRList = cService.printAllReply(boardNo);
		session.setAttribute("boardNo", comm.getBoardNo());
		mv.addObject("cRList", cRList);
		mv.addObject("comm", comm);
		mv.addObject("page", page);
		mv.setViewName("comm/commDetailView");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	 
	@RequestMapping(value = "/comm/modifyView.kh", method = RequestMethod.GET)
	public ModelAndView commModifyView(ModelAndView mv, @RequestParam("boardNo") Integer boardNo,
			@RequestParam("page") int page) {
		try {
			Comm comm = cService.printOneByNo(boardNo);
			mv.addObject("comm", comm);
			mv.addObject("page", page);
			mv.setViewName("comm/boardModifyForm");
		} catch (Exception e) {
			mv.addObject("msg", e.toString());
			mv.setViewName("main/errorPage");
		}
		return mv;
	}
	
	
	
	/**
	 * 게시글 수정
	 * 
	 * @param board
	 * @param mv
	 * @return
	 */
	@RequestMapping(value = "/comm/modify.kh", method = RequestMethod.POST)
	public ModelAndView commModify(@ModelAttribute Comm comm, ModelAndView mv,
			@RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile,
			@RequestParam("page") Integer page, HttpServletRequest request) {
		try {
			if (reloadFile != null) {
				String commFilename = reloadFile.getOriginalFilename();
				// 수정, 1. 대체(replace) / 2. 삭제 후 저장
				// 파일삭제
				String root = request.getSession().getServletContext().getRealPath("resources");
				String savedPath = root + "\\buploadFiles";
				File file = new File(savedPath + "\\" + comm.getCommFileRename());
				if (file.exists()) {
					file.delete();
				}
				// 파일 다시 저장
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String commFileRename = sdf.format(new Date(System.currentTimeMillis())) + "."
						+ commFilename.substring(commFilename.lastIndexOf(".") + 1);
				String commFilepath = savedPath + "\\" + commFileRename;
				reloadFile.transferTo(new File(commFilepath));
				comm.setCommFilename(commFilename);
				comm.setCommFileRename(commFileRename);
			}
			int result = cService.modifyBoard(comm);
			mv.addObject("comm", comm);
//			mv.setViewName("redirect:/free/detail.kh?boardNo=" + free.getBoardNo() + "&page=" + page);
			mv.setViewName("redirect:/comm/list.kh?page=" + page);
		} catch (Exception e) {
			mv.addObject("msg", e.toString()).setViewName("main/errorPage");
		}
		return mv;
	}
	
	/**
	 * 게시글 삭제
	 * 
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/comm/remove.kh", method = RequestMethod.GET)
	public String commRemove(HttpSession session, Model model, @RequestParam("page") Integer page) {
		try {
			int boardNo = (int) session.getAttribute("boardNo");
			int result = cService.removeOneByNo(boardNo);
			if (result > 0) {
				session.removeAttribute("boardNo");
			}
			return "redirect:/comm/list.kh?page=" + page;
		} catch (Exception e) {
			model.addAttribute("msg", e.toString());
			return "main/errorPage";
		}
	}
	
	/**
	 * 댓글 등록
	 * @param reply
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/comm/replyAdd.kh", method=RequestMethod.POST)
	public String boardReplyAdd(
			@ModelAttribute CommReply cReply
			, Principal principal) {		// RequstParam 대신 ModelAttribute를 사용할 수 있는 이유는
		/* cReply.setrWriter(); */	// 로그인한 아이디
		String userName = principal.getName();
		cReply.setrWriter(userName);
		int result = cService.registerReply(cReply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	/**
	 * 댓글 목록 출력
	 * @param boardNo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/comm/replyList.kh", produces="application/json;charset=utf-8", method=RequestMethod.GET)
	public String boardReplyList(
			@RequestParam("boardNo") int boardNo) {
		int bNo = (boardNo == 0) ? 1 : boardNo;
		List<CommReply> cRList = cService.printAllReply(bNo);
		if(!cRList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();		// 날짜형식 지정해줌.
			return gson.toJson(cRList);
		}
		return null;
	}
	
	@ResponseBody		// @ResponseBody 안써주면 404에러가 뜸 /WEB-INF/views/success.jsp 찾을 수 없다 에러나옴
	@RequestMapping(value="/comm/replyDelete.kh", method=RequestMethod.GET)
	public String boardReplyDelete(
			@RequestParam("cReplyNo") Integer cReplyNo) {
		int result = cService.deleteReply(cReplyNo);
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/comm/replyModify.kh", method=RequestMethod.POST)
	public String boardReplyModify(
			// @RequestParam("replyNo") Integer replyNo
			// , @RequestParam("replyContents") String replyContents
			@ModelAttribute CommReply cReply) {
		int result = cService.modifyReply(cReply);
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}

	
}
