package com.kh.ready.book.domain;

import java.sql.Date;

public class Review {
	//도서 평점
	private int reviewNo;
	private int bookNo;
	private String userId;
	private String nickName;
	private int score;
	private String reviewContents;
	private Date enrollDate;
	private Date updateDate;
	
	private Book book;
	
	public Review() {}
	
	public Review (int reviewNo, int bookNo, String userId, String nickName, int score, String reviewContents, Date enrollDate, Date updateDate, Book book) {
		super();
		this.reviewNo = reviewNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.nickName = nickName;
		this.score = score;
		this.reviewContents = reviewContents;
		this.enrollDate = enrollDate;
		this.updateDate = updateDate;
		this.book = book;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getReviewContents() {
		return reviewContents;
	}

	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", bookNo=" + bookNo + ", userId=" + userId + ", nickName=" + nickName
				+ ", score=" + score + ", reviewContents=" + reviewContents + ", enrollDate=" + enrollDate
				+ ", updateDate=" + updateDate + ", book=" + book + "]";
	}
}
