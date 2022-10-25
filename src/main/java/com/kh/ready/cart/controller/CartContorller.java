package com.kh.ready.cart.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.cart.service.CartService;

@Controller
public class CartContorller {

	@Autowired
	private CartService cartService;
	
	
	@ResponseBody
	@RequestMapping(value="/cart/insert.ready", method=RequestMethod.POST)
	public void insertCart(Cart cart, Principal principal) {
		
		try {
			String userId = principal.getName();
			cart.setUserId(userId);
			
			cartService.insertCart(cart);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@ResponseBody
	@RequestMapping(value="/cart/delete.ready", method=RequestMethod.POST)
	public void deleteCart(Cart cart, Principal principal, @RequestParam(value="checkArr[]") List<String> chArr) {
		
		try {
			String userId = principal.getName();
			cart.setUserId(userId);
			
			int cartNo = 0;
			
			for(String i : chArr) {   
				cartNo = Integer.parseInt(i);
				cart.setCartNo(cartNo);
				cartService.deleteCart(cart);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/cart/modifyCount.ready", method=RequestMethod.POST)
	public void modifyCart(Cart cart, Principal principal,
			@RequestParam("cartNo") int cartNo, @RequestParam("productCount") int productCount) {
		
		try {
			System.out.println(cartNo);
			System.out.println(productCount);
			
			String userId = principal.getName();
			
			cart.setCartNo(cartNo);
			cart.setUserId(userId);
			cart.setProductCount(productCount);
			
			cartService.modifyCart(cart);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value="/cart/cartView.ready", method=RequestMethod.GET)
	public ModelAndView showCartView(ModelAndView mv, Principal principal) {
		
		try {
			String userId = principal.getName();
			
			List<Cart> cartList = cartService.getCartdataByUserId(userId);
				
			mv.addObject("cartList", cartList);
			mv.setViewName("cart/cartPage");
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/main/errorPage");
		}
		return mv;
	}
}
