package com.kh.ready.book.service;

import java.util.List;

import com.kh.ready.book.domain.Book;

public interface BookService {
	//도서 등록
	public int registerBook(Book book);

	public List<Book> printAllBook();
}
