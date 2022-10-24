package com.kh.ready.book.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;
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

	@Override
	public Book selectOneByNo(SqlSessionTemplate session, Integer bookNo) {
		Book book = session.selectOne("BookMapper.selectOneBook", bookNo);
		return book;
	}

	@Override
	public int insertReview(SqlSessionTemplate session, Review review) {
		int result = session.insert("BookMapper.insertReview", review);
		return result;
	}

	@Override
	public int updateReview(SqlSessionTemplate session, Review review) {
		int result = session.update("BookMapper.updateReview", review);
		return result;
	}

	@Override
	public int deleteReview(SqlSessionTemplate session, Integer reviewNo) {
		int result = session.delete("BookMapper.deleteReview", reviewNo);
		return result;
	}

	@Override
	public List<Review> selectAllReview(SqlSessionTemplate session, Integer bookNo) {
		List<Review> rList = session.selectList("BookMapper.selectAllReview", bookNo);
		return rList;
	}

}
