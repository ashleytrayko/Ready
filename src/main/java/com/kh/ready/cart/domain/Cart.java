package com.kh.ready.cart.domain;

public class Cart {
	
	private int cartNo;
	private int bookNo;
	private long userIndex;
	private int productCount;
	private int productPrice;
	
	public Cart(){};
	
	public Cart(int cartNo, int bookNo, long userIndex, int productCount, int productPrice) {
		super();
		this.cartNo = cartNo;
		this.bookNo = bookNo;
		this.userIndex = userIndex;
		this.productCount = productCount;
		this.productPrice = productPrice;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public int getbookNo() {
		return bookNo;
	}

	public void setbookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public long getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(long userIndex) {
		this.userIndex = userIndex;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", bookNo=" + bookNo + ", userIndex=" + userIndex + ", productCount="
				+ productCount + ", productPrice=" + productPrice + "]";
	}
	
	
}
