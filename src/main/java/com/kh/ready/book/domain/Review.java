package com.kh.ready.book.domain;

import java.util.Date;

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
	
	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", bookNo=" + bookNo + ", userId=" + userId + ", nickName=" + nickName
				+ ", score=" + score + ", reviewContents=" + reviewContents + ", enrollDate=" + enrollDate
				+ ", updateDate=" + updateDate + "]";
	}
}
