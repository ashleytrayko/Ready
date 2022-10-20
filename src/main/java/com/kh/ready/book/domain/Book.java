package com.kh.ready.book.domain;

import java.sql.Date;

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
	
	//getter, setter
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
	
	//toString
	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookWriter=" + bookWriter + ", enrollDate="
				+ enrollDate + ", pubDate=" + pubDate + ", category=" + category + ", bookContents=" + bookContents
				+ ", ISBN=" + ISBN + ", priceSales=" + priceSales + ", mileage=" + mileage + ", imgPath=" + imgPath
				+ ", publisher=" + publisher + "]";
	}
	
	
}
