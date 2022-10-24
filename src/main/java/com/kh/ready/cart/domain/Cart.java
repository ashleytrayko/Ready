package com.kh.ready.cart.domain;

import com.kh.ready.book.domain.Book;

public class Cart {
	
	private int cartNo;
	private int bookNo;
	private String userId;
	private int productCount;
	private long productPrice;
	
	private Book book;
	
	public Cart(){}

	public Cart(int cartNo, int bookNo, String userId, int productCount, long productPrice, Book book) {
		super();
		this.cartNo = cartNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.book = book;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", bookNo=" + bookNo + ", userId=" + userId + ", productCount=" + productCount
				+ ", productPrice=" + productPrice + ", book=" + book + "]";
	};
	
	
	
	
}
