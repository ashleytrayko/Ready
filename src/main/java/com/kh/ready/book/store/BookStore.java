package com.kh.ready.book.store;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;

public interface BookStore {

	int insertBook(SqlSessionTemplate session, Book book);

	int deleteBook(SqlSessionTemplate session, Integer bookNo);

	List<Book> selectAllBook(SqlSessionTemplate session, int currentPage, int bookLimit);

	Book selectOneByNo(SqlSessionTemplate session, Integer bookNo);

	int insertReview(SqlSessionTemplate session, Review review);

	int updateReview(SqlSessionTemplate session, Review review);

	List<Review> selectAllReview(SqlSessionTemplate session, Integer bookNo);

	int selectTotalCount(SqlSessionTemplate session, String searchCondition, String searchValue);

	List<Book> selectAllByValue(SqlSessionTemplate session, String searchCondition, String searchValue, int currentPage,
			int bookLimit);

	List<Book> selectAllByCategory(SqlSessionTemplate session, String category, int currentPage, int bookLimit);

	List<Book> selectBestSeller(SqlSessionTemplate session);

	List<Book> selectNewBook(SqlSessionTemplate session);

	List<Book> selectAllByCategoryNewLine(SqlSessionTemplate session, String category);

	List<Book> selectAllByCategoryBestLine(SqlSessionTemplate session, String category);

	List<Book> selectRecommendBook(SqlSessionTemplate session, String userId);

	List<Book> selectNovel(SqlSessionTemplate session);

	List<Book> selectComic(SqlSessionTemplate session);

	List<Book> selectStudy(SqlSessionTemplate session);

	int selectTotalCategoryCount(SqlSessionTemplate session, String category);

	int deleteReview(SqlSessionTemplate session, Review review);

	int selectTotalMyReviewCount(SqlSessionTemplate session,String userId);

	List<Review> selectMyReview(SqlSessionTemplate session, String userId, int currentPage, int reviewLimit);

	List<Book> selectRecommendBook1(SqlSessionTemplate session, String userId, String answerGender);

	int selectInsertCount(SqlSessionTemplate session, int bookNo, String userId);

	List<Book> selectRecommendBook2(SqlSessionTemplate session, String userId, String answerLove);

	List<Book> selectRecommendBook3(SqlSessionTemplate session, String userId, String answerHobby);

	List<Book> selectRecommendBook4(SqlSessionTemplate session, String userId, String answerReason);

	List<Book> selectRecommendBook5(SqlSessionTemplate session, String userId, String answerWriter);

}
