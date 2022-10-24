package com.kh.ready.book.service.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;
import com.kh.ready.book.service.BookService;
import com.kh.ready.book.store.BookStore;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private SqlSessionTemplate session;
	@Autowired BookStore bStore;

	@Override
	public int registerBook(Book book) {
		int result = bStore.insertBook(session, book);
		return result;
	}

	@Override
	public List<Book> printAllBook() {
		List<Book> bList = bStore.selectAllBook(session);
		return bList;
	}

	@Override
	public Book printOneByNo(Integer bookNo) {
		Book book = bStore.selectOneByNo(session, bookNo);
		return book;
	}

	@Override
	public int registerReview(Review review) {
		int result = bStore.insertReview(session, review);
		return result;
	}

	@Override
	public int modifyReview(Review review) {
		int result = bStore.updateReview(session, review);
		return result;
	}

	@Override
	public int removeReview(Integer reviewNo) {
		int result = bStore.deleteReview(session, reviewNo);
		return result;
	}

	@Override
	public List<Review> printAllReview(Integer bookNo) {
		List<Review> rList = bStore.selectAllReview(session, bookNo);
		return rList;
	}

}
