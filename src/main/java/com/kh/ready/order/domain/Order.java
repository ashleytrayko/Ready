package com.kh.ready.order.domain;

import java.sql.Date;

import com.kh.ready.book.domain.Book;
import com.kh.ready.cart.domain.Cart;

public class Order {

	private int orderNo;
	private Integer bookNo;
	private String userId;
	private Integer productCount;
	private String orderRName;
	private String orderRPhone;
	private String orderAddress1;
	private String orderAddress2;
	private String orderAddress3;
	private String paymentMethod;
	private String orderState;
	private Date orderDate;
	private String orderId;
	private int productPrice;
	private int totalPrice; 
	
	private Book book;
	private Cart cart;
	
	public Order() {}

	public Order(int orderNo, Integer bookNo, String userId, Integer productCount, String orderRName,
			String orderRPhone, String orderAddress1, String orderAddress2, String orderAddress3, String paymentMethod,
			String orderState, Date orderDate, String orderId, int productPrice, int totalPrice, Book book, Cart cart) {
		super();
		this.orderNo = orderNo;
		this.bookNo = bookNo;
		this.userId = userId;
		this.productCount = productCount;
		this.orderRName = orderRName;
		this.orderRPhone = orderRPhone;
		this.orderAddress1 = orderAddress1;
		this.orderAddress2 = orderAddress2;
		this.orderAddress3 = orderAddress3;
		this.paymentMethod = paymentMethod;
		this.orderState = orderState;
		this.orderDate = orderDate;
		this.orderId = orderId;
		this.productPrice = productPrice;
		this.totalPrice = totalPrice;
		this.book = book;
		this.cart = cart;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getBookNo() {
		return bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", bookNo=" + bookNo + ", userId=" + userId + ", productCount="
				+ productCount + ", orderRName=" + orderRName + ", orderRPhone=" + orderRPhone + ", orderAddress1="
				+ orderAddress1 + ", orderAddress2=" + orderAddress2 + ", orderAddress3=" + orderAddress3
				+ ", paymentMethod=" + paymentMethod + ", orderState=" + orderState + ", orderDate=" + orderDate
				+ ", orderId=" + orderId + ", productPrice=" + productPrice + ", totalPrice=" + totalPrice + ", book="
				+ book + ", cart=" + cart + "]";
	}


}
