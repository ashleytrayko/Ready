package com.kh.ready.book.domain;

public class UpdateScore {
	private int bookNo;
	private double scoreAvg;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public double getScoreAvg() {
		return scoreAvg;
	}
	public void setScoreAvg(double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}
	@Override
	public String toString() {
		return "UpdateScore [bookNo=" + bookNo + ", scoreAvg=" + scoreAvg + "]";
	}
}
