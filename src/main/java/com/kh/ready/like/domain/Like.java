package com.kh.ready.like.domain;

import java.sql.Date;

public class Like {
	private int likeNo;
	private int boardNo;
//	private long userIndex;
	private String userId;
	private int likeCheck;
	private Date likeDate;
	
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Like(int likeNo, int boardNo, String userId, int likeCheck, Date likeDate) {
		super();
		this.likeNo = likeNo;
		this.boardNo = boardNo;
		this.userId = userId;
		this.likeCheck = likeCheck;
		this.likeDate = likeDate;
	}
	
	public int getLikeNo() {
		return likeNo;
	}
	public void setLikeNo(int likeNo) {
		this.likeNo = likeNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getLikeCheck() {
		return likeCheck;
	}
	public void setLikeCheck(int likeCheck) {
		this.likeCheck = likeCheck;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
	
	@Override
	public String toString() {
		return "Like [likeNo=" + likeNo + ", boardNo=" + boardNo + ", userId=" + userId + ", likeCheck=" + likeCheck
				+ ", likeDate=" + likeDate + "]";
	}
	
	
	
	
	
	
}
