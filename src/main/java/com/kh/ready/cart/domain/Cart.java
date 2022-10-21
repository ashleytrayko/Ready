package com.kh.ready.cart.domain;

public class Cart {
	
	private int cartNo;
	private int bookNo;
	private String userId;
	private int productCount;
	private long productPrice;
	
	public Cart(){};
	
	public Cart(int cartNo, int bookNo, String userId, int productCount, long productPrice) {
		super();
		this.cartNo = cartNo;
		this.bookNo = bookNo;
		this.userId = userId;
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

	public String getuserId() {
		return userId;
	}

	public void setuserId(String userId) {
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

	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", bookNo=" + bookNo + ", userId=" + userId + ", productCount="
				+ productCount + ", productPrice=" + productPrice + "]";
	}
	
	
}
