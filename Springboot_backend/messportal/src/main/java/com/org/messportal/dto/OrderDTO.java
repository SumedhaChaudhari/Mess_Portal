package com.org.messportal.dto;

import java.time.LocalDateTime;

import com.org.messportal.util.DELIVERY_TYPE;
import com.org.messportal.util.ORDER_STATUS;

public class OrderDTO {

	private int id;

	private DELIVERY_TYPE deliveryType;

	private ORDER_STATUS status;

	private LocalDateTime updatedTime;

	private int AddressId;

	private int menuId;

	private int customerId;

	private int vendorId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DELIVERY_TYPE getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(DELIVERY_TYPE deliveryType) {
		this.deliveryType = deliveryType;
	}

//	public String getOrderCode() {
//		return orderCode;
//	}
//
//	public void setOrderCode(String orderCode) {
//		this.orderCode = orderCode;
//	}

	public ORDER_STATUS getStatus() {
		return status;
	}

	public void setStatus(ORDER_STATUS status) {
		this.status = status;
	}

	public LocalDateTime getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(LocalDateTime updatedTime) {
		this.updatedTime = updatedTime;
	}

//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	public int getMenuId() {
		return menuId;
	}

	public int getAddressId() {
		return AddressId;
	}

	public void setAddressId(int addressId) {
		AddressId = addressId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", deliveryType=" + deliveryType + ", status=" + status + ", updatedTime="
				+ updatedTime + ", AddressId=" + AddressId + ", menuId=" + menuId + ", customerId=" + customerId
				+ ", vendorId=" + vendorId + "]";
	}

}
