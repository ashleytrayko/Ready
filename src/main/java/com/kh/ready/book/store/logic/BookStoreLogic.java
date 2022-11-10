package com.kh.ready.book.store.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.ready.book.domain.Book;
import com.kh.ready.book.domain.Review;
import com.kh.ready.book.domain.UpdateScore;
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
		setScore(session, review.getBookNo());
		return result;
	}

	@Override
	public int updateReview(SqlSessionTemplate session, Review review) {
		int result = session.update("BookMapper.updateReview", review);
		setScore(session, review.getBookNo());
		return result;
	}

	@Override
	public int deleteReview(SqlSessionTemplate session, Review review) {
		int result = session.delete("BookMapper.deleteReview", review.getReviewNo());
		setScore(session, review.getBookNo());
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
	public int selectTotalCategoryCount(SqlSessionTemplate session, String category) {
		int totalCategoryCount = session.selectOne("BookMapper.selectCategoryCount", category);
		return totalCategoryCount;
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
	public List<Book> selectAllByCategory(SqlSessionTemplate session, String category, int currentPage, int bookLimit) {
		int offset = (currentPage - 1) * bookLimit;
		RowBounds rowBounds = new RowBounds(offset, bookLimit);
		List<Book> bList = session.selectList("BookMapper.selectAllByCategory", category, rowBounds);
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

	@Override
	public List<Book> selectAllByCategoryNewLine(SqlSessionTemplate session, String category) {
		List<Book> bList1 = session.selectList("BookMapper.selectCategoryNewLine", category);
		return bList1;
	}

	@Override
	public List<Book> selectAllByCategoryBestLine(SqlSessionTemplate session, String category) {
		List<Book> bList2 = session.selectList("BookMapper.selectCategoryBestLine", category);
		return bList2;
	}

	@Override
	public List<Book> selectRecommendBook(SqlSessionTemplate session, String userId) {
		List<Book> bList3 = session.selectList("BookMapper.selectRecommendBook", userId);
		return bList3;
	}

	@Override
	public List<Book> selectNovel(SqlSessionTemplate session) {
		List<Book> bList4 = session.selectList("BookMapper.selectNovel");
		return bList4;
	}

	@Override
	public List<Book> selectComic(SqlSessionTemplate session) {
		List<Book> bList5 = session.selectList("BookMapper.selectComic");
		return bList5;
	}

	@Override
	public List<Book> selectStudy(SqlSessionTemplate session) {
		List<Book> bList6 = session.selectList("BookMapper.selectStudy");
		return bList6;
	}

	public void setScore(SqlSessionTemplate session, int bookNo) {
		Double scoreAvg = session.selectOne("BookMapper.selectScoreAvg", bookNo);
		if(scoreAvg == null) {
			scoreAvg = 0.0;
		}
		scoreAvg = (double) (Math.round(scoreAvg*10));
		scoreAvg = scoreAvg / 10;
		UpdateScore urd = new UpdateScore();
		urd.setBookNo(bookNo);
		urd.setScoreAvg(scoreAvg);
			
		session.update("BookMapper.updateScoreAvg", urd);
	}

	@Override
	public int selectTotalMyReviewCount(SqlSessionTemplate session,String userId) {
		int selectTotalMyReviewCount = session.selectOne("BookMapper.selectMyReviewCount", userId);
		return selectTotalMyReviewCount;
	}

	@Override
	public List<Review> selectMyReview(SqlSessionTemplate session, String userId, int currentPage, int reviewLimit) {
		int offset = (currentPage - 1) * reviewLimit;
		RowBounds rowBounds = new RowBounds(offset, reviewLimit);
		List<Review> rList = session.selectList("BookMapper.selectMyReview", userId, rowBounds);
		return rList;
	}

	@Override
	public List<Book> selectRecommendBook1(SqlSessionTemplate session, String userId, String answerGender) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("answerGender", answerGender);
		List<Book> rbook1 = session.selectList("BookMapper.selectRecommendBook1", paramMap);
		return rbook1;
	}

	@Override
	public List<Book> selectRecommendBook2(SqlSessionTemplate session, String userId, String answerLove) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("userId", userId);
		paramMap.put("answerGender", answerLove);
		List<Book> rbook2 = session.selectList("BookMapper.selectRecommendBook2", paramMap);
		return rbook2;
	}
	
	@Override
	public int selectInsertCount(SqlSessionTemplate session, int bookNo, String userId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bookNo", bookNo);
		paramMap.put("userId", userId);
		int insertCount = session.selectOne("BookMapper.selectInsertCount", paramMap);
		return insertCount;
	}



}
