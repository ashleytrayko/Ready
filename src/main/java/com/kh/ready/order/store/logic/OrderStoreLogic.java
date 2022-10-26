package com.kh.ready.order.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ready.cart.domain.Cart;
import com.kh.ready.order.store.OrderStore;
import com.kh.ready.user.domain.User;

@Repository
public class OrderStoreLogic implements OrderStore{

	@Autowired
	private SqlSession session;

	@Override
	public List<Cart> getCartdataByUserId(String userId) {

		return session.selectList("OrderMapper.selectCartListByUserId", userId);
	}

	@Override
	public User getUserInfoByUserId(String userId) {

		return session.selectOne("UserMapper.selectOneUser",userId);
	}
	
}
