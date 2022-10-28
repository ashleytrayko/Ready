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
	public int removeBook(Integer bookNo) {
		int result = bStore.deleteBook(session, bookNo);
		return result;
	}

	@Override
	public List<Book> printAllBook(int currentPage, int bookLimit) {
		List<Book> bList = bStore.selectAllBook(session, currentPage, bookLimit);
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

	@Override
	public int getTotalCount(String searchCondition, String searchValue) {
		int totalCount = bStore.selectTotalCount(session, searchCondition, searchValue);
		return totalCount;
	}

	@Override
	public List<Book> printAllByValue(String searchCondition, String searchValue, int currentPage, int bookLimit) {
		List<Book> bList = bStore.selectAllByValue(session, searchCondition, searchValue, currentPage, bookLimit);
		return bList;
	}

	@Override
	public List<Book> printAllByCategory(String category) {
		List<Book> bList = bStore.selectAllByCategory(session, category);
		return bList;
	}

	@Override
	public List<Book> printBestSeller() {
		List<Book> bList1 = bStore.selectBestSeller(session);
		return bList1;
	}

	@Override
	public List<Book> printNewBook() {
		List<Book> bList2 = bStore.selectNewBook(session);
		return bList2;
	}

}
