package com.kh.ready.book.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.store.BookStore;

@Repository
public class BookStoreLogic implements BookStore{

	@Override
	public int insertBook(SqlSessionTemplate session, Book book) {
		int result = session.insert("BookMapper.insertBook", book);
		return result;
	}

	@Override
	public List<Book> selectAllBook(SqlSessionTemplate session) {
		List<Book> bList = session.selectList("BookMapper.selectAllBook");
		return bList;
	}

}
