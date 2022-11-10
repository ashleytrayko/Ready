package com.kh.ready.like.domain;

import java.sql.Date;

public class Like {
	private int likeNo;		// 추천수
	private int boardNo;	// 추천한 게시글 번호
	private String commId;	// 추천한 회원 아이디
	private int likeCheck;	// 추천했는지 여부
	private Date likeDate;	// 추천한 날짜
	
	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int likeNo, int boardNo, String commId, int likeCheck, Date likeDate) {
		super();
		this.likeNo = likeNo;
		this.boardNo = boardNo;
		this.commId = commId;
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

	public String getCommId() {
		return commId;
	}

	public void setCommId(String commId) {
		this.commId = commId;
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
		return "Like [likeNo=" + likeNo + ", boardNo=" + boardNo + ", commId=" + commId + ", likeCheck=" + likeCheck
				+ ", likeDate=" + likeDate + "]";
	}
	
	
	
	
	
	
	
}
