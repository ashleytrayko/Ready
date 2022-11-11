package com.kh.ready.order.service.logic;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.book.domain.Book;
import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.domain.Order;
import com.kh.ready.order.service.OrderService;
import com.kh.ready.order.store.OrderStore;
import com.kh.ready.user.domain.User;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderStore orderStore;

	@Override
	public List<Cart> getCartdataByUserId(String userId) {

		return orderStore.getCartdataByUserId(userId);
	}

	@Override
	public Book getbookDataByBookNo(int bookNo) {

		return orderStore.getbookDataByBookNo(bookNo);
	}

	@Override
	public User getUserInfoByUserId(String userId) {

		return orderStore.getUserInfoByUserId(userId);
	}

	@Override
	public int insertOrder(Order order) {

		return orderStore.insertOrder(order);
	}

	@Override
	public int deleteCart(String userId) {

		return orderStore.deleteCart(userId);
	}

	@Override
	public List<Order> getOrderDataByOrderId(String orderId) {

		return orderStore.getOrderDataByOrderId(orderId);
	}

	@Override
	public Order getOrderInfoByOrderId(String orderId) {

		return orderStore.getOrderInfoByOrderId(orderId);
	}

	@Override
	public int updateMileageByUserId(String userId, int usedMileage) {

		return orderStore.updateMileageByUserId(userId, usedMileage);
	}

	@Override
	public int updateStatusByOrderId(String orderId) {

		return orderStore.updateStatusByOrderId(orderId);
	}

	@Override
	public int updatePurchaseInfoByUserId(String userId, int plusedMileage, int userPurchase) {
		
		String userTier = "BRONZE";
		
		if(userPurchase >= 200000 && userPurchase < 500000) {
			userTier = "SILVER";	
		} else if(userPurchase >= 500000 && userPurchase < 1000000) {
			userTier = "GOLD";
		} else if(userPurchase >= 1000000) {
			userTier = "VIP";
		}
		
		return orderStore.updatePurchaseInfoByUserId(userId, plusedMileage, userTier, userPurchase);
	}

	@Override
	public int updateOrderState(String orderId) {

		return orderStore.updateOrderState(orderId);
	}

}
