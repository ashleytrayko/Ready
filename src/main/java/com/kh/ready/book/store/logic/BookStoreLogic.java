package com.kh.ready.book.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
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
	public int deleteBook(SqlSessionTemplate session, Integer bookNo) {
		int result = session.delete("BookMapper.deleteBook", bookNo);
		return result;
	}

	@Override
	public List<Book> selectAllBook(SqlSessionTemplate session, int currentPage, int bookLimit) {
		int offset = (currentPage - 1) * bookLimit;
		RowBounds rowBounds = new RowBounds(offset, bookLimit);
		List<Book> bList = session.selectList("BookMapper.selectAllBook", null, rowBounds);
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

	@Override
	public int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		int totalCount = session.selectOne("BookMapper.selectTotalCount", paramMap);
		return totalCount;
	}

	@Override
	public List<Book> selectAllByValue(SqlSessionTemplate session, String searchCondition, String searchValue,
			int currentPage, int bookLimit) {
		int offset = (currentPage - 1) * bookLimit;
		RowBounds rowBounds = new RowBounds(offset, bookLimit);
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchValue", searchValue);
		List<Book> bList = session.selectList("BookMapper.selectAllByValue", paramMap, rowBounds);
		return bList;
	}

	@Override
	public List<Book> selectAllByCategory(SqlSessionTemplate session, String category) {
		List<Book> bList = session.selectList("BookMapper.selectAllByCategory", category);
		return bList;
	}

	@Override
	public List<Book> selectBestSeller(SqlSessionTemplate session) {
		List<Book> bList1 = session.selectList("BookMapper.selectBestSeller");
		return bList1;
	}

	@Override
	public List<Book> selectNewBook(SqlSessionTemplate session) {
		List<Book> bList2 = session.selectList("BookMapper.selectNewBook");
		return bList2;
	}


}
