package com.kh.ready.cart.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.cart.service.CartService;
import com.kh.ready.cart.store.CartStore;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartStore cartStore;


	@Override
	public int insertCart(Cart cart) {

		return cartStore.insertCart(cart);
	}


	@Override
	public List<Cart> getCartdataByUserId(String userId) {
		
		return cartStore.getCartdataByUserId(userId);
	}

	
}
