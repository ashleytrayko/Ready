package com.kh.ready.book.service;

import java.util.List;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;

public interface BookService {
	//도서 등록
	public int registerBook(Book book);

	public List<Book> printAllBook();

	public Book printOneByNo(Integer bookNo);

	public int registerReview(Review review);

	public int modifyReview(Review review);

	public int removeReview(Integer reviewNo);

	public List<Review> printAllReview(Integer bookNo);
}
