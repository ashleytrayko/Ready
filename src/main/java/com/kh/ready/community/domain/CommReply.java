package com.kh.ready.community.domain;

import java.sql.Date;

public class CommReply {

	private int cReplyNo;		// 댓글번호
	private int boardNo;		// 참조게시글번호
	private String rWriter;		// 작성자
	private String rContents;	// 댓글내용
	private Date rCreateDate;	// 댓글등록일
	private Date rUpdateDate;	// 댓글수정일
	private String rStatus;		// 댓글상태
	private int rGroup;			// 댓글분류
	private int rParentReplyNo;	// 원댓글번호
	private int rChildReplyNo;	// 답글번호
	
	
	public CommReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CommReply(int cReplyNo, int boardNo, String rWriter, String rContents, Date rCreateDate, Date rUpdateDate,
			String rStatus, int rGroup, int rParentReplyNo, int rChildReplyNo) {
		super();
		this.cReplyNo = cReplyNo;
		this.boardNo = boardNo;
		this.rWriter = rWriter;
		this.rContents = rContents;
		this.rCreateDate = rCreateDate;
		this.rUpdateDate = rUpdateDate;
		this.rStatus = rStatus;
		this.rGroup = rGroup;
		this.rParentReplyNo = rParentReplyNo;
		this.rChildReplyNo = rChildReplyNo;
	}
	
	
	public int getcReplyNo() {
		return cReplyNo;
	}
	public void setcReplyNo(int cReplyNo) {
		this.cReplyNo = cReplyNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getrWriter() {
		return rWriter;
	}
	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	public String getrContents() {
		return rContents;
	}
	public void setrContents(String rContents) {
		this.rContents = rContents;
	}
	public Date getrCreateDate() {
		return rCreateDate;
	}
	public void setrCreateDate(Date rCreateDate) {
		this.rCreateDate = rCreateDate;
	}
	public Date getrUpdateDate() {
		return rUpdateDate;
	}
	public void setrUpdateDate(Date rUpdateDate) {
		this.rUpdateDate = rUpdateDate;
	}
	public String getrStatus() {
		return rStatus;
	}
	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}
	public int getrGroup() {
		return rGroup;
	}
	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}
	public int getrParentReplyNo() {
		return rParentReplyNo;
	}
	public void setrParentReplyNo(int rParentReplyNo) {
		this.rParentReplyNo = rParentReplyNo;
	}
	public int getrChildReplyNo() {
		return rChildReplyNo;
	}
	public void setrChildReplyNo(int rChildReplyNo) {
		this.rChildReplyNo = rChildReplyNo;
	}
	
	
	@Override
	public String toString() {
		return "CommReply [cReplyNo=" + cReplyNo + ", boardNo=" + boardNo + ", rWriter=" + rWriter + ", rContents="
				+ rContents + ", rCreateDate=" + rCreateDate + ", rUpdateDate=" + rUpdateDate + ", rStatus=" + rStatus
				+ ", rGroup=" + rGroup + ", rParentReplyNo=" + rParentReplyNo + ", rChildReplyNo=" + rChildReplyNo
				+ "]";
	}


	
	
}
