package com.kh.ready.order.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.service.OrderService;
import com.kh.ready.order.store.OrderStore;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderStore orderStore;

	@Override
	public List<Cart> getCartdataByUserId(String userId) {
		
		return orderStore.getCartdataByUserId(userId);
	}
	
}
