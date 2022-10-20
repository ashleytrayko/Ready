package com.kh.ready.cart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.cart.service.CartService;

@Controller
public class CartContorller {

	
	@Autowired
	private CartService cartService;
	

	@RequestMapping(value="", method=RequestMethod.POST)
	public ModelAndView insertCart(ModelAndView mv) {
		
//		int result = cartService.insertCart();
		
		return mv;
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
