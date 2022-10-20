package com.kh.ready.order.domain;

import java.sql.Date;

public class Order {

	private int orderNo;
	private int bookNo;
	private long userIndex;
	private int productCount;
	private int productPrice;
	private int totalPrice;
	private String orderId;
	private String orderRName;
	private String orderRPhone;
	private String orderAddress1;
	private String orderAddress2;
	private String orderAddress3;
	private String paymentMethod;
	private String orderState;
	private Date orderDate;
	
	public Order() {}

	public Order(int orderNo, int bookNo, long userIndex, int productCount, int productPrice, int totalPrice,
			String orderId, String orderRName, String orderRPhone, String orderAddress1, String orderAddress2,
			String orderAddress3, String paymentMethod, String orderState, Date orderDate) {
		super();
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.userIndex = userIndex;
		this.productCount = productCount;
		this.productPrice = productPrice;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
		this.orderRName = orderRName;
		this.orderRPhone = orderRPhone;
		this.orderAddress1 = orderAddress1;
		this.orderAddress2 = orderAddress2;
		this.orderAddress3 = orderAddress3;
		this.paymentMethod = paymentMethod;
		this.orderState = orderState;
		this.orderDate = orderDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderRName() {
		return orderRName;
	}

	public void setOrderRName(String orderRName) {
		this.orderRName = orderRName;
	}

	public String getOrderRPhone() {
		return orderRPhone;
	}

	public void setOrderRPhone(String orderRPhone) {
		this.orderRPhone = orderRPhone;
	}

	public String getOrderAddress1() {
		return orderAddress1;
	}

	public void setOrderAddress1(String orderAddress1) {
		this.orderAddress1 = orderAddress1;
	}

	public String getOrderAddress2() {
		return orderAddress2;
	}

	public void setOrderAddress2(String orderAddress2) {
		this.orderAddress2 = orderAddress2;
	}

	public String getOrderAddress3() {
		return orderAddress3;
	}

	public void setOrderAddress3(String orderAddress3) {
		this.orderAddress3 = orderAddress3;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", bookNo=" + bookNo + ", userIndex=" + userIndex + ", productCount="
				+ productCount + ", productPrice=" + productPrice + ", totalPrice=" + totalPrice + ", orderId="
				+ orderId + ", orderRName=" + orderRName + ", orderRPhone=" + orderRPhone + ", orderAddress1="
				+ orderAddress1 + ", orderAddress2=" + orderAddress2 + ", orderAddress3=" + orderAddress3
				+ ", paymentMethod=" + paymentMethod + ", orderState=" + orderState + ", orderDate=" + orderDate + "]";
	}

	
	
}
