package com.kh.ready.order.controller;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.domain.Order;
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
	public void insertOrder(Order order, Principal principal, @RequestParam("cartList") String cartList,
															   @RequestParam("totalPrice") String totalPrice,
															   @RequestParam("buyerName") String buyerName,
															   @RequestParam("buyerPhone") String buyerPhone,
															   @RequestParam("buyerPostCode") String buyerPostCode,
															   @RequestParam("buyerAddr") String buyerAddr) {

		 System.out.println(cartList);
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
		 
		 order.setOrderId(orderId);
		 order.setUserId(userId);
		 
		
		 System.out.println(totalPrice);
		 System.out.println(order.getOrderId());
		 
//		 orderService.insertOrder(order, cart);
		 
		 
	}
}