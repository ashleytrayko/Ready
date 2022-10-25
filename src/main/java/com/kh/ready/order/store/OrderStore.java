package com.kh.ready.order.store;

import java.util.List;

import com.kh.ready.cart.domain.Cart;

public interface OrderStore {

	List<Cart> getCartdataByUserId(String userId);

}
