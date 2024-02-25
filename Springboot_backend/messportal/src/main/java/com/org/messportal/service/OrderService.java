package com.org.messportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.messportal.dto.OrderDTO;
import com.org.messportal.entity.Order;
import com.org.messportal.entity.User;

public interface OrderService {
	public ResponseEntity<Order> findOrderById(int id);

	public ResponseEntity<List<String>> findAllBookingOrders();

	public ResponseEntity<List<String>> findAllDeliveryOrders();

	public ResponseEntity<OrderDTO> addAllOrders(OrderDTO orderDto, User customer);

}
