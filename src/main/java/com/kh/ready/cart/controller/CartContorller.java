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
import com.kh.ready.user.domain.User;

@Controller
public class CartContorller {

	@Autowired
	private CartService cartService;
	
	@ResponseBody
	@RequestMapping(value="/cart/insert", method=RequestMethod.POST)
	public int insertCart(Cart cart, Principal principal){
		
		try {
			String userId = principal.getName();
			cart.setUserId(userId);
			
			int result = cartService.insertCart(cart);

			return result;			
		} catch (Exception e) {
			return 0;
		}
	}

	
	@ResponseBody
	@RequestMapping(value="/cart/delete", method=RequestMethod.POST)
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
	@RequestMapping(value="/cart/modifyCount", method=RequestMethod.POST)
	public void modifyCart(Cart cart, Principal principal,
			@RequestParam("cartNo") int cartNo, @RequestParam("productCount") int productCount) {
		
		try {
			String userId = principal.getName();
			
			cart.setCartNo(cartNo);
			cart.setUserId(userId);
			cart.setProductCount(productCount);
			
			cartService.modifyCart(cart);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@RequestMapping(value="/cart/cartView", method=RequestMethod.GET)
	public ModelAndView showCartView(ModelAndView mv, Principal principal) {
		
		try {
			String userId = principal.getName();
			
			List<Cart> cartList = cartService.getCartdataByUserId(userId);
			
			User userInfo = cartService.getUserInfoByUserId(userId);
			String userTier = userInfo.getUserTier();
			double discountRate = 0;
			
			if(userTier.equals("BRONZE")) {
				discountRate = 0.99;
			} else if(userTier.equals("SILVER")) {
				discountRate = 0.97;
			} else if(userTier.equals("GOLD")) {
				discountRate = 0.95;
			} else if(userTier.equals("VIP")) {
				discountRate = 0.90;
			}
			mv.addObject("discountRate",discountRate);
			
			mv.addObject("userInfo", userInfo);
			mv.addObject("cartList", cartList);
			mv.setViewName("cart/cartPage");
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/main/errorPage");
		}
		return mv;
	}
}
