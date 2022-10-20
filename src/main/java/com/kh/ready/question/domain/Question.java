package com.kh.ready.question.domain;

import java.sql.Date;

public class Question {

	private int queNo;				// 문의글 번호
	private String queWriter;		// 작성자
	private String queTitle;		// 제목
	private String queContents;		// 내용
	private String queFilename;		// 파일이름
	private String queFileRename;	// 변경된 파일이름
	private String queFilePath;		// 파일저장경로
	private Date qEnrollDate;		// 글 등록일
	private String qAnswer;			// 답변
	private String qStatus;			// 답변여부
	private String qCategory;		// 문의유형
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int queNo, String queWriter, String queTitle, String queContents, String queFilename,
			String queFileRename, String queFilePath, Date qEnrollDate, String qAnswer, String qStatus,
			String qCategory) {
		super();
		this.queNo = queNo;
		this.queWriter = queWriter;
		this.queTitle = queTitle;
		this.queContents = queContents;
		this.queFilename = queFilename;
		this.queFileRename = queFileRename;
		this.queFilePath = queFilePath;
		this.qEnrollDate = qEnrollDate;
		this.qAnswer = qAnswer;
		this.qStatus = qStatus;
		this.qCategory = qCategory;
	}

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public String getQueWriter() {
		return queWriter;
	}

	public void setQueWriter(String queWriter) {
		this.queWriter = queWriter;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getQueContents() {
		return queContents;
	}

	public void setQueContents(String queContents) {
		this.queContents = queContents;
	}

	public String getQueFilename() {
		return queFilename;
	}

	public void setQueFilename(String queFilename) {
		this.queFilename = queFilename;
	}

	public String getQueFileRename() {
		return queFileRename;
	}

	public void setQueFileRename(String queFileRename) {
		this.queFileRename = queFileRename;
	}

	public String getQueFilePath() {
		return queFilePath;
	}

	public void setQueFilePath(String queFilePath) {
		this.queFilePath = queFilePath;
	}

	public Date getqEnrollDate() {
		return qEnrollDate;
	}

	public void setqEnrollDate(Date qEnrollDate) {
		this.qEnrollDate = qEnrollDate;
	}

	public String getqAnswer() {
		return qAnswer;
	}

	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}

	public String getqStatus() {
		return qStatus;
	}

	public void setqStatus(String qStatus) {
		this.qStatus = qStatus;
	}

	public String getqCategory() {
		return qCategory;
	}

	public void setqCategory(String qCategory) {
		this.qCategory = qCategory;
	}

	@Override
	public String toString() {
		return "Question [queNo=" + queNo + ", queWriter=" + queWriter + ", queTitle=" + queTitle + ", queContents="
				+ queContents + ", queFilename=" + queFilename + ", queFileRename=" + queFileRename + ", queFilePath="
				+ queFilePath + ", qEnrollDate=" + qEnrollDate + ", qAnswer=" + qAnswer + ", qStatus=" + qStatus
				+ ", qCategory=" + qCategory + "]";
	}
	
	
}
