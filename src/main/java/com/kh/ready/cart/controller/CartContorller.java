package com.kh.ready.cart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.book.domain.Book;
import com.kh.ready.cart.domain.Cart;
import com.kh.ready.cart.service.CartService;

@Controller
public class CartContorller {

	
	@Autowired
	private CartService cartService;
	
	@ResponseBody
	@RequestMapping(value="/cart/insert.ready", method=RequestMethod.POST)
	public void insertCart(Cart cart, HttpSession session) {
		//Member member = (Member)session.getAttribute("loginMember");
		String userId = "khuser01";
		
		cart.setuserId(userId);
		System.out.println(cart);
		
		cartService.insertCart(cart);
		
//		return result;
	}

	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView deleteCart(ModelAndView mv) {
		
//		int result = cartService.deleteCart();
		
		return mv;
	}
	

	@RequestMapping(value="/cart/cartView.ready", method=RequestMethod.GET)
	public ModelAndView showCartView(ModelAndView mv, HttpSession session) {
		
		
		mv.setViewName("cart/cartPage");
		return mv;
	}
}
