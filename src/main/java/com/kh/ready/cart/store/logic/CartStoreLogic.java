package com.kh.ready.cart.store.logic;

import java.util.List;

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
		
		return session.insert("CartMapper.insertCart", cart);
	}


	@Override
	public List<Cart> getCartdataByUserId(String userId) {

		return session.selectList("CartMapper.selectCartListByUserId", userId);
	}

	
}