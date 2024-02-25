package com.org.messportal.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.org.messportal.entity.User;
import com.org.messportal.util.ACTIVE;
import com.org.messportal.util.SUBSCRIBE_TYPE;

public class SubscriptionDTO {

	private int id;

	private ACTIVE active;

	private Date subscriptionExpireDate;

	private SUBSCRIBE_TYPE subscriptionType;

	private int totalAmount;

	private LocalDateTime updatedTime;

	private int menuId;

	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ACTIVE getActive() {
		return active;
	}

	public void setActive(ACTIVE active) {
		this.active = active;
	}

	public Date getSubscriptionExpireDate() {
		return subscriptionExpireDate;
	}

	public void setSubscriptionExpireDate(Date subscriptionExpireDate) {
		this.subscriptionExpireDate = subscriptionExpireDate;
	}

	public SUBSCRIBE_TYPE getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SUBSCRIBE_TYPE subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubscriptionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubscriptionDTO [id=" + id + ", active=" + active + ", subscriptionExpireDate=" + subscriptionExpireDate
				+ ", subscriptionType=" + subscriptionType + ", totalAmount=" + totalAmount + ", updatedTime="
				+ updatedTime + ", menuId=" + menuId + ", user=" + user + "]";
	}

}
