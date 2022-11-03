package com.kh.ready.order.controller;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ready.book.domain.Book;
import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.domain.Order;
import com.kh.ready.order.service.OrderService;
import com.kh.ready.user.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(OrderController.class);

	
	@RequestMapping(value="/order/orderView", method=RequestMethod.GET)
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
	
	@RequestMapping(value="/order/directOrderView", method=RequestMethod.GET)
	public ModelAndView getDirectOrderData(ModelAndView mv, Principal principal, User user,
								@RequestParam("bookNo") int bookNo,
								@RequestParam("productCount") int productCount) {
		
		try {
			
			String userId = principal.getName();

			Book bookData = orderService.getbookDataByBookNo(bookNo);
			User userInfo = orderService.getUserInfoByUserId(userId);
			
			mv.addObject("productCount" , productCount);
			mv.addObject("bookData", bookData);
			mv.addObject("userInfo", userInfo);
			mv.setViewName("/order/orderPageDirect");
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/main/errorPage");
		}

		return mv;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/order/insertOrder", method=RequestMethod.POST)
	public String insertOrder(Principal principal, @RequestParam("bookNoArr[]") List<Integer> bookNoArr,
												@RequestParam("productCountArr[]") List<Integer> productCountArr,
												@RequestParam("reciverName") String reciverName,
												@RequestParam("productPriceArr[]") List<Integer> productPriceArr,
												@RequestParam("reciverPhone") String reciverPhone,
												@RequestParam("reciverZoneCode") String reciverZoneCode,
												@RequestParam("reciverRoadAddr") String reciverRoadAddr,
												@RequestParam("reciverDetailAddr") String reciverDetailAddr,
												@RequestParam("paymethod") String paymethod){
				
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
				
				int result = 0;
				
				for(int i=0; i<bookNoArr.size(); i++) {
					
					order.setBookNo(bookNoArr.get(i));
					order.setProductCount(productCountArr.get(i));
					order.setProductPrice(productPriceArr.get(i));
					order.setOrderRName(reciverName);
					order.setOrderRPhone(reciverPhone);
					order.setOrderAddress1(reciverZoneCode);
					order.setOrderAddress2(reciverRoadAddr);
					order.setOrderAddress3(reciverDetailAddr);
					order.setPaymentMethod(paymethod);
					order.setOrderId(orderId);
					order.setUserId(userId);
					
					result = orderService.insertOrder(order);
				}
				
				if(result > 0) {
					orderService.deleteCart(userId);
				}
				
				String getOrderId = order.getOrderId();
				
			return getOrderId;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/order/insertDirectOrder", method=RequestMethod.POST)
	public String insertDirectOrder(Principal principal, @RequestParam("bookNo") int bookNo,
												@RequestParam("productCount") int productCount,
												@RequestParam("productPrice") int productPrice,
												@RequestParam("reciverName") String reciverName,
												@RequestParam("reciverPhone") String reciverPhone,
												@RequestParam("reciverZoneCode") String reciverZoneCode,
												@RequestParam("reciverRoadAddr") String reciverRoadAddr,
												@RequestParam("reciverDetailAddr") String reciverDetailAddr,
												@RequestParam("paymethod") String paymethod){
			
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
			
			order.setBookNo(bookNo);
			order.setProductCount(productCount);
			order.setProductPrice(productPrice);
			order.setOrderRName(reciverName);
			order.setOrderRPhone(reciverPhone);
			order.setOrderAddress1(reciverZoneCode);
			order.setOrderAddress2(reciverRoadAddr);
			order.setOrderAddress3(reciverDetailAddr);
			order.setPaymentMethod(paymethod);
			order.setOrderId(orderId);
			order.setUserId(userId);
			
			orderService.insertOrder(order);
			
			
			String getOrderId = order.getOrderId();
			return getOrderId;
	}
	
	@RequestMapping(value="/order/orderDetailView", method=RequestMethod.GET)
	public ModelAndView orderDetailView(ModelAndView mv, String orderId, Principal principal) {
		
		String userId = principal.getName();
		User userInfo = orderService.getUserInfoByUserId(userId);
		
		Order orderInfo = orderService.getOrderInfoByOrderId(orderId);
		List<Order> orderList = orderService.getOrderDataByOrderId(orderId);
		
		mv.addObject("userInfo",userInfo);
		mv.addObject("orderInfo",orderInfo);
		mv.addObject("orderList", orderList);
		System.out.println(orderList);
		mv.setViewName("/order/orderCompletePage");
		return mv;
	}
	
}