package com.org.messportal.dto;

import java.io.Serializable;
import java.util.List;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3707446596404294434L;

	private int id;

	private String active;

	private String email;

	private String userIdProof;
	private String userName;
	private String userPhone;
	private String password;
	private List<AddressDTO> addresses;
	private int roleId;
	private String roleDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", active=" + active + ", email=" + email + ", userIdProof=" + userIdProof
				+ ", userName=" + userName + ", userPhone=" + userPhone + ", password=" + password + ", addresses="
				+ addresses + ", roleId=" + roleId + ", roleDescription=" + roleDescription + "]";
	}

}
