package com.kh.ready.cart.controller;


import java.security.Principal;
import java.util.List;

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
	public void insertCart(Cart cart, Principal principal) {
		
		String userId = principal.getName();
		
		cart.setUserId(userId);
		
		cartService.insertCart(cart);
		
//		return result;
	}

	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView deleteCart(ModelAndView mv) {
		
//		int result = cartService.deleteCart();
		
		return mv;
	}
	

	@RequestMapping(value="/cart/cartView.ready", method=RequestMethod.GET)
	public ModelAndView showCartView(ModelAndView mv, Principal principal) {
		
		String userId = principal.getName();
		
		List<Cart> cartList = cartService.getCartdataByUserId(userId);

		System.out.println(cartList);
		
		mv.addObject("cartList", cartList);
		mv.setViewName("cart/cartPage");
		
		return mv;
	}
}
