package com.kh.ready.book.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.book.domain.Book;

public interface BookStore {

	int insertBook(SqlSessionTemplate session, Book book);

	List<Book> selectAllBook(SqlSessionTemplate session);

}
