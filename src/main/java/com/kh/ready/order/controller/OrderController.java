package com.kh.ready.order.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.service.OrderService;
import com.kh.ready.user.domain.User;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/order/orderView.ready", method=RequestMethod.GET)
	public ModelAndView showOrderView(ModelAndView mv, Principal principal, Cart cart, User user) {
		try {
			String userId = principal.getName();
			
			List<Cart> cartList = orderService.getCartdataByUserId(userId);
			User userInfoList = orderService.getUserInfoByUserId(userId);
			
			System.out.println(userInfoList);
			
			mv.addObject("cartList", cartList);
			mv.addObject("userInfoList", userInfoList);
			mv.setViewName("/order/orderPage");
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/main/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/order/insert.ready", method=RequestMethod.GET)
	public void insertOrder() {
		
		
	}
}