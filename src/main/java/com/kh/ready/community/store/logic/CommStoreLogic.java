package com.kh.ready.community.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.ready.community.domain.Comm;
import com.kh.ready.community.store.CommStore;

@Repository
public class CommStoreLogic implements CommStore{

	@Override
	public int insertBoard(SqlSession session, Comm comm) {
		int result = session.insert("CommMapper.insertBoard", comm);
		return result;
	}

}
