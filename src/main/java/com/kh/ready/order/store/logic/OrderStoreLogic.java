package com.kh.ready.order.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ready.order.store.OrderStore;

@Repository
public class OrderStoreLogic implements OrderStore{

	@Autowired
	private SqlSession session;
	
}
