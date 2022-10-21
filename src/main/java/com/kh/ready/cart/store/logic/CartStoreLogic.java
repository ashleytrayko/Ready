package com.kh.ready.cart.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.cart.store.CartStore;

@Repository
public class CartStoreLogic implements CartStore{

	@Autowired
	private SqlSession session;

	
	@Override
	public int insertCart(Cart cart) {
		int result = session.insert("CartMapper.insertCart", cart);
		return result;
	}
	
}