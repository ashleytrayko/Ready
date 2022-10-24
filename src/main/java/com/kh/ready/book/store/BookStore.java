package com.kh.ready.book.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;

public interface BookStore {

	int insertBook(SqlSessionTemplate session, Book book);

	List<Book> selectAllBook(SqlSessionTemplate session);

	Book selectOneByNo(SqlSessionTemplate session, Integer bookNo);

	int insertReview(SqlSessionTemplate session, Review review);

	int updateReview(SqlSessionTemplate session, Review review);

	int deleteReview(SqlSessionTemplate session, Integer reviewNo);

	List<Review> selectAllReview(SqlSessionTemplate session, Integer bookNo);

}
