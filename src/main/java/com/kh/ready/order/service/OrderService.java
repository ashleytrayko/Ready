package com.kh.ready.order.service;

import java.util.List;

import com.kh.ready.cart.domain.Cart;

public interface OrderService {

	List<Cart> getCartdataByUserId(String userId);

}
