package com.org.messportal.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.org.messportal.util.DELIVERY_TYPE;
import com.org.messportal.util.ORDER_STATUS;

/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "delivery_type")
	private DELIVERY_TYPE deliveryType;

	@Column(name = "order_code")
	private String orderCode;

	// private int orderNumber;

	@Column
	private ORDER_STATUS status;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

	// bi-directional many-to-one association to Address
	@ManyToOne
	private Address address;

	// bi-directional many-to-one association to MenuDetail
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private MenuDetail menuDetail;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User user1;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private User user2;

	public Order() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
//
//	public String getComments() {
//		return this.comments;
//	}
//
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//
//	public int getCustomerNumber() {
//		return this.customerNumber;
//	}
//
//	public void setCustomerNumber(int customerNumber) {
//		this.customerNumber = customerNumber;
//	}

	public DELIVERY_TYPE getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DELIVERY_TYPE deliveryType) {
		this.deliveryType = deliveryType;
	}

	public void setStatus(ORDER_STATUS status) {
		this.status = status;
	}

	public String getOrderCode() {
		return this.orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
//
//	public int getOrderId() {
//		return this.orderId;
//	}
//
//	public void setOrderId(int orderId) {
//		this.orderId = orderId;
//	}
//
//	public Date getOrderDate() {
//		return this.orderDate;
//	}
//
//	public void setOrderDate(Date orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public int getOrdernumber() {
//		return this.ordernumber;
//	}
//
//	public void setOrdernumber(int ordernumber) {
//		this.ordernumber = ordernumber;
//	}

//	public int getOrderNumber() {
//		return this.orderNumber;
//	}
//
//	public void setOrderNumber(int orderNumber) {
//		this.orderNumber = orderNumber;
//	}

//	public int getPersonid() {
//		return this.personid;
//	}
//
//	public void setPersonid(int personid) {
//		this.personid = personid;
//	}
//
//	public Date getRequiredDate() {
//		return this.requiredDate;
//	}
//
//	public void setRequiredDate(Date requiredDate) {
//		this.requiredDate = requiredDate;
//	}
//
//	public Date getShippedDate() {
//		return this.shippedDate;
//	}
//
//	public void setShippedDate(Date shippedDate) {
//		this.shippedDate = shippedDate;
//	}

	public Address getAddress() {
		return this.address;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MenuDetail getMenuDetail() {
		return this.menuDetail;
	}

	public void setMenuDetail(MenuDetail menuDetail) {
		this.menuDetail = menuDetail;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}