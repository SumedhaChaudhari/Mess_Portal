package com.org.messportal.entity;

import java.io.Serializable;
import java.time.LocalDate;
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

import com.org.messportal.util.ACTIVE;
import com.org.messportal.util.SUBSCRIBE_TYPE;

/**
 * The persistent class for the user_subscription database table.
 * 
 */
@Entity
@Table(name = "user_subscription")
@NamedQuery(name = "UserSubscription.findAll", query = "SELECT u FROM UserSubscription u")
public class UserSubscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private ACTIVE active;

	@Column(name = "subscription_expire_date")
	private LocalDate subscriptionExpireDate;

	@Column(name = "subscription_type")
	private SUBSCRIBE_TYPE subscriptionType;

	@Column(name = "total_amount")
	private int totalAmount;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

	// bi-directional many-to-one association to MenuDetail
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private MenuDetail menuDetail;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User user;

	public UserSubscription() {
	}

	public int getId() {
		return this.id;
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

	public LocalDate getSubscriptionExpireDate() {
		return subscriptionExpireDate;
	}

	public void setSubscriptionExpireDate(LocalDate subscriptionExpireDate) {
		this.subscriptionExpireDate = subscriptionExpireDate;
	}

	public SUBSCRIBE_TYPE getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SUBSCRIBE_TYPE subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public int getTotalAmount() {
		return this.totalAmount;
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

	public MenuDetail getMenuDetail() {
		return this.menuDetail;
	}

	public void setMenuDetail(MenuDetail menuDetail) {
		this.menuDetail = menuDetail;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}