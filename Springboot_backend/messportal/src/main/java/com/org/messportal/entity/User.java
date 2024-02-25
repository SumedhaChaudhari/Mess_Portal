package com.org.messportal.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.org.messportal.util.ACTIVE;
import com.org.messportal.util.VERIFIED;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private ACTIVE active;

	@Column
	private String email;

	@Column(name = "email_verification_code")
	private String emailVerificationCode;

	@Column
	private String password;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

	@Column(name = "user_id_proof")
	private String userIdProof;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_phone")
	private String userPhone;

	@Column
	private VERIFIED verified;

	// bi-directional many-to-one association to Address
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> addresses;

	// bi-directional many-to-one association to MenuDetail
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<MenuDetail> menuDetails;

//	//bi-directional many-to-one association to Order
//	@OneToMany(mappedBy="user1")
//	private List<Order> orders1;
//
//	//bi-directional many-to-one association to Order
//	@OneToMany(mappedBy="user2")
//	private List<Order> orders2;

	// bi-directional many-to-one association to UserSubscription
	@OneToMany(mappedBy = "user")
	private List<UserSubscription> userSubscriptions;

	// bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public User() {
	}

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

	public VERIFIED getVerified() {
		return verified;
	}

	public void setVerified(VERIFIED verified) {
		this.verified = verified;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailVerificationCode() {
		return emailVerificationCode;
	}

	public void setEmailVerificationCode(String emailVerificationCode) {
		this.emailVerificationCode = emailVerificationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getUserIdProof() {
		return userIdProof;
	}

	public void setUserIdProof(String userIdProof) {
		this.userIdProof = userIdProof;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<MenuDetail> getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(List<MenuDetail> menuDetails) {
		this.menuDetails = menuDetails;
	}

//	public List<Order> getOrders1() {
//		return orders1;
//	}
//
//	public void setOrders1(List<Order> orders1) {
//		this.orders1 = orders1;
//	}
//
//	public List<Order> getOrders2() {
//		return orders2;
//	}
//
//	public void setOrders2(List<Order> orders2) {
//		this.orders2 = orders2;
//	}

	public List<UserSubscription> getUserSubscriptions() {
		return userSubscriptions;
	}

	public void setUserSubscriptions(List<UserSubscription> userSubscriptions) {
		this.userSubscriptions = userSubscriptions;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}