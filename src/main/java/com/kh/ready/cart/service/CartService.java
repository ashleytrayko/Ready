package com.kh.ready.cart.service;

import java.util.List;

import com.kh.ready.cart.domain.Cart;

public interface CartService {

	int insertCart(Cart cart);

	List<Cart> getCartdataByUserId(String userId);

}
