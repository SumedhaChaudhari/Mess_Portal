package com.org.messportal.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.org.messportal.util.ACTIVE;
import com.org.messportal.util.MENU_TYPE;

/**
 * The persistent class for the menu_details database table.
 * 
 */
@Entity
@Table(name = "menu_details")
@NamedQuery(name = "MenuDetail.findAll", query = "SELECT m FROM MenuDetail m")
public class MenuDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private ACTIVE active;

	@Column
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "expire_date")
	private Date expireDate;

	@Column
	private int price;

	@Column
	private MENU_TYPE type;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private User user;

	// bi-directional many-to-one association to Order
	@OneToMany(mappedBy = "menuDetail")
	private List<Order> orders;

	// bi-directional many-to-one association to UserSubscription
	@OneToMany(mappedBy = "menuDetail")
	private List<UserSubscription> userSubscriptions;

	public MenuDetail() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpireDate() {
		return this.expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public int getPrice() {
		return this.price;
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setMenuDetail(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setMenuDetail(null);

		return order;
	}

	public List<UserSubscription> getUserSubscriptions() {
		return this.userSubscriptions;
	}

	public void setUserSubscriptions(List<UserSubscription> userSubscriptions) {
		this.userSubscriptions = userSubscriptions;
	}

	public UserSubscription addUserSubscription(UserSubscription userSubscription) {
		getUserSubscriptions().add(userSubscription);
		userSubscription.setMenuDetail(this);

		return userSubscription;
	}

	public UserSubscription removeUserSubscription(UserSubscription userSubscription) {
		getUserSubscriptions().remove(userSubscription);
		userSubscription.setMenuDetail(null);

		return userSubscription;
	}

	public int getVendorId() {
		// TODO Auto-generated method stub
		return 0;
	}

}