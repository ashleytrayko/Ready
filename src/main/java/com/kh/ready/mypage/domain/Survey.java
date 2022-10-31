package com.kh.ready.mypage.domain;

import java.sql.Date;

public class Survey {
	private String userId;
	private String answerGender;
	private String answerLove;
	private String answerHobby;
	private String answerReason;
	private String answerWriter;
	private Date enrollDate;
	private Date updateDate;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAnswerGender() {
		return answerGender;
	}
	public void setAnswerGender(String answerGender) {
		this.answerGender = answerGender;
	}
	public String getAnswerLove() {
		return answerLove;
	}
	public void setAnswerLove(String answerLove) {
		this.answerLove = answerLove;
	}
	public String getAnswerHobby() {
		return answerHobby;
	}
	public void setAnswerHobby(String answerHobby) {
		this.answerHobby = answerHobby;
	}
	public String getAnswerReason() {
		return answerReason;
	}
	public void setAnswerReason(String answerReason) {
		this.answerReason = answerReason;
	}
	public String getAnswerWriter() {
		return answerWriter;
	}
	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
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
		return "Survey [userId=" + userId + ", answerGender=" + answerGender + ", answerLove=" + answerLove
				+ ", answerHobby=" + answerHobby + ", answerReason=" + answerReason + ", answerWriter=" + answerWriter
				+ ", enrollDate=" + enrollDate + ", updateDate=" + updateDate + "]";
	}
}
