package com.kh.ready.order.controller;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value="/order/orderView", method=RequestMethod.GET)
	public ModelAndView showOrderView(ModelAndView mv, Principal principal, Cart cart, User user) {
		
		try {
			String userId = principal.getName();
			
			List<Cart> cartList = orderService.getCartdataByUserId(userId);
			User userInfo = orderService.getUserInfoByUserId(userId);
			
			mv.addObject("discountRate", discountRate(userId));
			mv.addObject("cartList", cartList);
			mv.addObject("userInfo", userInfo);
			mv.setViewName("/order/orderPageCart");
			
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
			
			mv.addObject("discountRate", discountRate(userId));
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
	@RequestMapping(value="/order/insertCartOrder", method=RequestMethod.POST)
	public String insertOrder(Principal principal, @RequestParam("bookNoArr[]") List<Integer> bookNoArr,
												@RequestParam("productCountArr[]") List<Integer> productCountArr,
												@RequestParam("productPriceArr[]") List<Integer> productPriceArr,
												@RequestParam("mileageSum") int mileageSum,
												@RequestParam("useMileage") int useMileage,
												@RequestParam("totalPrice") int totalPrice,
												@RequestParam("reciverName") String reciverName,
												@RequestParam("reciverPhone") String reciverPhone,
												@RequestParam("reciverZoneCode") String reciverZoneCode,
												@RequestParam("reciverRoadAddr") String reciverRoadAddr,
												@RequestParam("reciverDetailAddr") String reciverDetailAddr,
												@RequestParam("imp_uid") String imp_uid,
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
				
				User user = orderService.getUserInfoByUserId(userId);
				int result = 0;
				
				int usedMileage = user.getUserReserves() - useMileage;
				
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
					order.setTotalPrice(totalPrice);
					order.setUseMileage(useMileage);
					order.setImpUid(imp_uid);
					
					result = orderService.insertOrder(order);
					
				}
					orderService.updateMileageByUserId(userId, usedMileage);
					
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
												@RequestParam("totalPrice") int totalPrice,
												@RequestParam("mileageSum") int mileageSum,
												@RequestParam("reciverName") String reciverName,
												@RequestParam("reciverPhone") String reciverPhone,
												@RequestParam("reciverZoneCode") String reciverZoneCode,
												@RequestParam("reciverRoadAddr") String reciverRoadAddr,
												@RequestParam("reciverDetailAddr") String reciverDetailAddr,
												@RequestParam("paymethod") String paymethod,
												@RequestParam("imp_uid") String imp_uid,
												@RequestParam("useMileage") int useMileage){
			
			Order order = new Order();
			
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
			String ymd = ym +  new DecimalFormat("00").format(cal.get(Calendar.DATE));
			String subNum = "";
			
			for(int i = 1; i <= 6; i ++) {
				subNum += (int)(Math.random() * 10);
			}
			
			System.out.println(productPrice);
			
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
			order.setTotalPrice(totalPrice);
			order.setUseMileage(useMileage);
			order.setImpUid(imp_uid);
			orderService.insertOrder(order);
			
			User userInfo = orderService.getUserInfoByUserId(userId);
			int usedMileage = userInfo.getUserReserves() - useMileage;
			orderService.updateMileageByUserId(userId, usedMileage);
			
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
		mv.setViewName("/order/orderCompletePage");
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value="/order/confirmPurchase", method=RequestMethod.POST)
	public int confirmPurchase(Principal principal, @RequestParam("plusMileage") int plusMileage,
													@RequestParam("orderId") String orderId,
													@RequestParam("salePriceSum") int salePriceSum) {
		
		String userId = principal.getName();
		
		User userInfo = orderService.getUserInfoByUserId(userId);
		int plusedMileage = userInfo.getUserReserves() + plusMileage;
		int userPurchase = userInfo.getUserPurchase() + salePriceSum;
		
		int updateorderStatus = orderService.updateStatusByOrderId(orderId);
		int updataUserInfo = orderService.updatePurchaseInfoByUserId(userId, plusedMileage, userPurchase);
		
		int result = updateorderStatus + updataUserInfo;
		
		return result;
	}
	
	public double discountRate(String userId) {
		
		User userInfo = orderService.getUserInfoByUserId(userId);
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
		
		return discountRate;
	}
	
}