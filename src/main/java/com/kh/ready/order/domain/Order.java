package com.kh.ready.order.domain;

public class Order {

	private int orderId;
	private int bookNo;
	private long userIndex;
	private int productCount;
	private int productPrice;
	
	public Order() {}

	public Order(int orderId, int bookNo, long userIndex, int productCount, int productPrice) {
		super();
		this.orderId = orderId;
		this.bookNo = bookNo;
		this.userIndex = userIndex;
		this.productCount = productCount;
		this.productPrice = productPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
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
		return "Order [orderId=" + orderId + ", bookNo=" + bookNo + ", userIndex=" + userIndex + ", productCount="
				+ productCount + ", productPrice=" + productPrice + "]";
	};
	
	
}
