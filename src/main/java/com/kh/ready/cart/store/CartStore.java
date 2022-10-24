package com.kh.ready.cart.store;

import java.util.List;

import com.kh.ready.cart.domain.Cart;

public interface CartStore {

	int insertCart(Cart cart);

	List<Cart> getCartdataByUserId(String userId);


}
