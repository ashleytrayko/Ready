package com.kh.ready.order.service;

import java.util.List;

import com.kh.ready.book.domain.Book;
import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.domain.Order;
import com.kh.ready.user.domain.User;

public interface OrderService {

	List<Cart> getCartdataByUserId(String userId);

	User getUserInfoByUserId(String userId);

	int insertOrder(Order order);

	int deleteCart(String userId);

	Book getbookDataByBookNo(int bookNo);

	List<Order> getOrderDataByOrderId(String orderId);

	Order getOrderInfoByOrderId(String orderId);
	
}
