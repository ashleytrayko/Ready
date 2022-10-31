package com.kh.ready.order.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.domain.Order;
import com.kh.ready.order.service.OrderService;
import com.kh.ready.user.domain.User;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OrderController.class);

	
	@RequestMapping(value="/order/orderView.ready", method=RequestMethod.GET)
	public ModelAndView showOrderView(ModelAndView mv, Principal principal, Cart cart, User user) {
		try {
			String userId = principal.getName();
			
			List<Cart> cartList = orderService.getCartdataByUserId(userId);
			User userInfoList = orderService.getUserInfoByUserId(userId);
			
//			orderService.getNeedDataByUserId(userId);

			List<Cart> needList = orderService.getNeedDataByUserId(userId);
			
			System.out.println(needList);
			
			mv.addObject("needList", needList);
			mv.addObject("cartList", cartList);
			mv.addObject("userInfoList", userInfoList);
			
			mv.setViewName("/order/orderPage");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/main/errorPage");
		}
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/order/insert.ready", method=RequestMethod.POST)
	public void insertOrder(Principal principal, @RequestParam("bookNoArr[]") List<Integer> bookNoArr,
															@RequestParam("productCountArr[]") List<Integer> productCountArr) {

		 
		 System.out.println(bookNoArr);
		 System.out.println(productCountArr);
		 
		 Order order = new Order();
		 
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		 String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
		 String subNum = "";
		 
		 for(int i = 1; i <= 6; i ++) {
			  subNum += (int)(Math.random() * 10);
		 }

		 String orderId = ymd + "_" + subNum;
		 String userId = principal.getName();

		 
		 for(int i=0; i<=bookNoArr.size(); i++) {
			 	
				order.setBookNo(bookNoArr.get(i));
				order.setProductCount(productCountArr.get(i));
				order.setOrderId(orderId);
				order.setUserId(userId);
				
				int result = orderService.insertOrder(order);
		 }
		 
		 
		
		 System.out.println(order.getOrderId());
		 
//		 orderService.insertOrder(order, cart);
		 
		 
	}
}