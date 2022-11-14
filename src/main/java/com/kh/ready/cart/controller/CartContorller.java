package com.kh.ready.cart.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping(value="/cart/insert")
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
	@PostMapping(value="/cart/delete")
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
	@PostMapping(value="/cart/modifyCount")
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
	

	@GetMapping(value="/cart/cartView")
	public ModelAndView showCartView(ModelAndView mv, Principal principal) {
		
		try {
			String userId = principal.getName();
			
			List<Cart> cartList = cartService.getCartdataByUserId(userId);
			
			User userInfo = cartService.getUserInfoByUserId(userId);
			String userTier = userInfo.getUserTier();
			double discountRate = 0;
			String discountPercent = "";
			
			if(userTier.equals("BRONZE")) {
				discountRate = 0.99;
				discountPercent = "1%";
			} else if(userTier.equals("SILVER")) {
				discountRate = 0.97;
				discountPercent = "3%";
			} else if(userTier.equals("GOLD")) {
				discountRate = 0.95;
				discountPercent = "5%";
			} else if(userTier.equals("VIP")) {
				discountRate = 0.90;
				discountPercent = "10%";
			}
			mv.addObject("discountPercent", discountPercent);
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
