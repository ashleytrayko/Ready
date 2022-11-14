package com.kh.ready.community.domain;

import java.sql.Date;

public class Comm {

	private int boardNo;			// 게시글번호
	private String commWriter;		// 작성자
	private String commTitle;		// 제목
	private String commContents;	// 내용
	private String commFilename;	// 파일이름
	private String commFileRename;	// 변경된 파일이름
	private String commFilePath;	// 파일저장경로
	private Date cCreateDate;		// 게시글 등록일
	private Date cUpdateDate;		// 게시글 수정일
	private String cStatus;			// 게시글 상태
	private int cLike;				// 추천수
	private int cCount;				// 조회수
	private String commId;			// 아이디
	private String reportResult;	// 신고처리 결과
	
	
	public Comm() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Comm(int boardNo, String commWriter, String commTitle, String commContents, String commFilename,
			String commFileRename, String commFilePath, Date cCreateDate, Date cUpdateDate, String cStatus, int cLike,
			int cCount, String commId) {
		super();
		this.boardNo = boardNo;
		this.commWriter = commWriter;
		this.commTitle = commTitle;
		this.commContents = commContents;
		this.commFilename = commFilename;
		this.commFileRename = commFileRename;
		this.commFilePath = commFilePath;
		this.cCreateDate = cCreateDate;
		this.cUpdateDate = cUpdateDate;
		this.cStatus = cStatus;
		this.cLike = cLike;
		this.cCount = cCount;
		this.commId = commId;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getCommWriter() {
		return commWriter;
	}


	public void setCommWriter(String commWriter) {
		this.commWriter = commWriter;
	}


	public String getCommTitle() {
		return commTitle;
	}


	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}


	public String getCommContents() {
		return commContents;
	}


	public void setCommContents(String commContents) {
		this.commContents = commContents;
	}


	public String getCommFilename() {
		return commFilename;
	}


	public void setCommFilename(String commFilename) {
		this.commFilename = commFilename;
	}


	public String getCommFileRename() {
		return commFileRename;
	}


	public void setCommFileRename(String commFileRename) {
		this.commFileRename = commFileRename;
	}


	public String getCommFilePath() {
		return commFilePath;
	}


	public void setCommFilePath(String commFilePath) {
		this.commFilePath = commFilePath;
	}


	public Date getcCreateDate() {
		return cCreateDate;
	}


	public void setcCreateDate(Date cCreateDate) {
		this.cCreateDate = cCreateDate;
	}


	public Date getcUpdateDate() {
		return cUpdateDate;
	}


	public void setcUpdateDate(Date cUpdateDate) {
		this.cUpdateDate = cUpdateDate;
	}


	public String getcStatus() {
		return cStatus;
	}


	public void setcStatus(String cStatus) {
		this.cStatus = cStatus;
	}


	public int getcLike() {
		return cLike;
	}


	public void setcLike(int cLike) {
		this.cLike = cLike;
	}


	public int getcCount() {
		return cCount;
	}


	public void setcCount(int cCount) {
		this.cCount = cCount;
	}


	public String getCommId() {
		return commId;
	}


	public void setCommId(String commId) {
		this.commId = commId;
	}
	
	

	public String getReportResult() {
		return reportResult;
	}


	public void setReportResult(String reportResult) {
		this.reportResult = reportResult;
	}


	@Override
	public String toString() {
		return "Comm [boardNo=" + boardNo + ", commWriter=" + commWriter + ", commTitle=" + commTitle
				+ ", commContents=" + commContents + ", commFilename=" + commFilename + ", commFileRename="
				+ commFileRename + ", commFilePath=" + commFilePath + ", cCreateDate=" + cCreateDate + ", cUpdateDate="
				+ cUpdateDate + ", cStatus=" + cStatus + ", cLike=" + cLike + ", cCount=" + cCount + ", commId="
				+ commId + ", reportResult=" + reportResult + "]";
	}


	


	
	
	
}
