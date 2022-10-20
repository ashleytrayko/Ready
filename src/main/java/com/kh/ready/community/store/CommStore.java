package com.kh.ready.community.store;

import org.apache.ibatis.session.SqlSession;

import com.kh.ready.community.domain.Comm;

public interface CommStore {

	int insertBoard(SqlSession session, Comm comm);

}
