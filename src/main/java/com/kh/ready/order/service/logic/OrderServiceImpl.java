package com.kh.ready.order.service.logic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.domain.Order;
import com.kh.ready.order.service.OrderService;
import com.kh.ready.order.store.OrderStore;
import com.kh.ready.user.domain.User;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderStore orderStore;

	@Override
	public List<Cart> getCartdataByUserId(String userId) {
		
		return orderStore.getCartdataByUserId(userId);
	}

	@Override
	public User getUserInfoByUserId(String userId) {

		return orderStore.getUserInfoByUserId(userId);
	}

	@Override
	public List<Cart> getNeedDataByUserId(String userId) {

		return orderStore.getNeedDataByUserId(userId);
	}

	@Override
	public int insertOrder(Order order) {
		
		return orderStore.insertOrder(order);
	}
	
}
