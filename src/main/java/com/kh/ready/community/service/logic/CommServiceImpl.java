package com.kh.ready.community.service.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.service.CommService;
import com.kh.ready.community.store.CommStore;

@Service
public class CommServiceImpl implements CommService{
	@Autowired
	private SqlSession session;
	@Autowired
	private CommStore cStore;

	@Override
	public int registerBoard(Comm comm) {
		int result = cStore.insertBoard(session, comm);
		return result;
	}

}
