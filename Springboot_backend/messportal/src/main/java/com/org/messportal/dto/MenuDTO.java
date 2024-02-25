package com.org.messportal.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.org.messportal.util.MENU_TYPE;

public class MenuDTO {

	private int id;

	private String description;

	private Date expireDate;

	private int price;

	private MENU_TYPE type;

	private LocalDateTime updatedTime;

	private int vendorId;

//	private List<Order> orders;
//
//	private List<UserSubscription> userSubscriptions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MENU_TYPE getType() {
		return type;
	}

	public void setType(MENU_TYPE type) {
		this.type = type;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}
//
//	public List<UserSubscription> getUserSubscriptions() {
//		return userSubscriptions;
//	}
//
//	public void setUserSubscriptions(List<UserSubscription> userSubscriptions) {
//		this.userSubscriptions = userSubscriptions;
//	}

}
