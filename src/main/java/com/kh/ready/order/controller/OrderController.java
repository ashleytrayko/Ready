package com.kh.ready.order.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping(value="/order/orderView")
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
	
	@GetMapping(value="/order/directOrderView")
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
	@PostMapping(value="/order/insertCartOrder")
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
												@RequestParam("orderId") String orderId,
												@RequestParam("paymethod") String paymethod){
				
				Order order = new Order();
				
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
	@PostMapping(value="/order/insertDirectOrder")
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
												@RequestParam("orderId") String orderId,
												@RequestParam("useMileage") int useMileage){
			
			Order order = new Order();
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
	
	
	@GetMapping(value="/order/orderDetailView")
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
	@PostMapping(value="/order/confirmPurchase")
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
	
	@ResponseBody
	@PostMapping(value="/order/refund")
	public String refund(@RequestParam(value="orderId") String orderId, @RequestParam(value="impUid") String impUid) {
		
		
		OutputStreamWriter osw;
		BufferedWriter bw;
		InputStreamReader isr;
		BufferedReader br;
		StringBuffer sb = new StringBuffer();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObjectParam = new JSONObject();
		JSONObject jsonObjectResult;
		
		String accUrl="https://api.iamport.kr/payments/cancel";
		
		String access_token = getToken();
		try {
			URL url = new URL(accUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization","Bearer "+ access_token);
			
			Order orderInfo = orderService.getOrderInfoByOrderId(orderId);
			int updatestate = orderService.updateOrderState(orderId);
			
			jsonObjectParam.put("merchant_uid", orderId);
			jsonObjectParam.put("imp_uid", impUid);
			
			System.out.println(jsonObjectParam.toString());
			
			osw = new OutputStreamWriter(con.getOutputStream());
			bw = new BufferedWriter(osw);
			bw.write(jsonObjectParam.toString());
			bw.flush();
			
			isr = new InputStreamReader(con.getInputStream());
			br = new BufferedReader(isr);
			
			if(con.getResponseCode() == 200) {
				String line = "";
				sb = new StringBuffer();
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				jsonObjectResult = (JSONObject)jsonParser.parse(sb.toString());
				System.out.println(jsonObjectResult.toString());
				if(Integer.parseInt(jsonObjectResult.get("code").toString())!=0) {
					//환불 실패
					return "fail";
				}else if(updatestate>0){
					return "success";
				}
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "fail";
	}

	
		public String getToken() {
			 OutputStreamWriter osw;
			 BufferedWriter bw;
			 InputStreamReader isr;
			 BufferedReader br;
			 StringBuffer sb = new StringBuffer();
			 JSONParser jsonParser = new JSONParser();
			 JSONObject jsonObjectParam = new JSONObject();
			 JSONObject jsonObjectResult;
			
			String accUrl = "https://api.iamport.kr/users/getToken";
			
			try {
				//url객체를 생성 후 주소 입력
				URL url = new URL(accUrl);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setDoOutput(true);
				con.setRequestProperty("Content-Type", "application/json");
				
				//환불요청 시 필요한 값인 imp_key, imp_secret을  json객체에 put
				jsonObjectParam.put("imp_key", "2668574740488838");
				jsonObjectParam.put("imp_secret","Q44VoZAfwC9pWRV8qaC83RwB2wZgC1rrjd7OVECCDMvwMeilYD3n4KIw1hR5nmsE9PeESLEMh0Be2M1j");
				
				//문자출력스트림 요청
				osw = new OutputStreamWriter(con.getOutputStream());
				bw = new BufferedWriter(osw);
				bw.write(jsonObjectParam.toString());
				bw.flush();
				
				//문자입력스트림 응답
				isr = new InputStreamReader(con.getInputStream());
				br = new BufferedReader(isr);
				if(con.getResponseCode() == 200) {
					String line = "";
					sb = new StringBuffer();
					while((line = br.readLine()) != null) {
						sb.append(line);
					}
					//응답받은 문자열을 json객체로 만들고 필요한 값을 뽑기
					jsonObjectResult = (JSONObject)jsonParser.parse(sb.toString());
					JSONObject responseJson = (JSONObject)jsonObjectResult.get("response");
					String access_token = responseJson.get("access_token").toString();
					return access_token;
					
				}else {
					return "";
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return "";
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