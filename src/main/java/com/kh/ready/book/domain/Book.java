package com.kh.ready.book.domain;

import java.sql.Date;

import com.kh.ready.mypage.domain.Survey;

public class Book {
	private int bookNo;
	private String bookTitle;
	private String bookWriter;
	private Date enrollDate;
	private String pubDate;
	private String category;
	private String bookContents;
	private String ISBN;
	private long priceSales;
	private long mileage;
	private String imgPath;
	private String publisher;
	private int saleCount;
	private double scoreAvg;
	
	private Survey survey;
	
	public Book() {}
	
	public Book(int bookNo, String bookTitle, String bookWriter, Date enrollDate, String pubDate, String category, String bookContents, String ISBN, long priceSales, long mileage, String imgPath, String publisher, int saleCount, double scoreAvg, Survey survey) {
		super();
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.enrollDate = enrollDate;
		this.pubDate = pubDate;
		this.category = category;
		this.bookContents = bookContents;
		this.ISBN = ISBN;
		this.priceSales = priceSales;
		this.mileage = mileage;
		this.imgPath = imgPath;
		this.publisher = publisher;
		this.saleCount = saleCount;
		this.scoreAvg = scoreAvg;
		this.survey = survey;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBookContents() {
		return bookContents;
	}

	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public long getPriceSales() {
		return priceSales;
	}

	public void setPriceSales(long priceSales) {
		this.priceSales = priceSales;
	}

	public long getMileage() {
		return mileage;
	}

	public void setMileage(long mileage) {
		this.mileage = mileage;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public double getScoreAvg() {
		return scoreAvg;
	}

	public void setScoreAvg(double scoreAvg) {
		this.scoreAvg = scoreAvg;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookWriter=" + bookWriter + ", enrollDate="
				+ enrollDate + ", pubDate=" + pubDate + ", category=" + category + ", bookContents=" + bookContents
				+ ", ISBN=" + ISBN + ", priceSales=" + priceSales + ", mileage=" + mileage + ", imgPath=" + imgPath
				+ ", publisher=" + publisher + ", saleCount=" + saleCount + ", scoreAvg=" + scoreAvg + ", survey="
				+ survey + "]";
	}	
}
