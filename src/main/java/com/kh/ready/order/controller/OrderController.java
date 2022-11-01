package com.kh.ready.order.controller;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.nimbusds.jose.util.IntegerUtils;

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
	
	@ResponseBody
	@RequestMapping(value="/order/getDirectOrderData", method=RequestMethod.GET)
	public String getDirectOrderData(Principal principal, User user,
								@RequestParam("bookNo") String getBookNo,
								@RequestParam("productCount") String getProductCount,
								Model model) {
		String userId = principal.getName();
		
		int bookNo = Integer.valueOf(getBookNo);
		int productCount = Integer.valueOf(getProductCount);
		System.out.println(bookNo);
		System.out.println(productCount);
		
		Book bookData = orderService.getbookDataByBookNo(bookNo);
		User userInfo = orderService.getUserInfoByUserId(userId);
		List<Object> orderData = new ArrayList<Object>();
		orderData.add(bookData);
		orderData.add(userInfo);
		System.out.println(orderData);
		model.addAttribute(bookData);
		model.addAttribute(userInfo);
		
		return "/order/directOrderView";
	}
	
	@RequestMapping(value="/order/directOrderView", method=RequestMethod.GET)
	public ModelAndView showDirectOrderView(ModelAndView mv) {
		try {
			

			/*
			 * mv.addObject("userInfoList", userInfoList);
			 * mv.setViewName("/order/orderPageDirect");
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("/main/errorPage");
		}
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/order/insertOrder", method=RequestMethod.POST)
	public void insertOrder(Principal principal, @RequestParam("bookNoArr[]") List<Integer> bookNoArr,
												@RequestParam("productCountArr[]") List<Integer> productCountArr,
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

		 int result = 0;
		 
		 for(int i=0; i<bookNoArr.size(); i++) {
			 	
				order.setBookNo(bookNoArr.get(i));
				order.setProductCount(productCountArr.get(i));
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
	}
	
}