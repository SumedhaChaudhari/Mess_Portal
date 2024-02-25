package com.org.messportal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.messportal.dto.OrderDTO;
import com.org.messportal.entity.Order;
import com.org.messportal.entity.User;
import com.org.messportal.service.OrderService;
import com.org.messportal.service.UserService;

@RestController
@RequestMapping("/messportal/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable int id) {
		return orderService.findOrderById(id);
	}

	@GetMapping("/delivery")
	public ResponseEntity<List<String>> findAllDeliveries() {
		return orderService.findAllDeliveryOrders();
	}

	@GetMapping("/booked")
	public ResponseEntity<List<String>> findAllBookings() {
		return orderService.findAllBookingOrders();
	}

	@PostMapping("/add")
	public ResponseEntity<OrderDTO> addAll(@RequestBody OrderDTO orderDto, HttpServletRequest request) {
		System.out.println(orderDto.toString());
		User customer = userService.getUserFromToken(request.getHeader("Authorization"));
		return orderService.addAllOrders(orderDto, customer);
	}

//	@PostMapping("/book/add/{id}")
//	public ResponseEntity<Order> addBooking(@PathVariable int id, HttpServletRequest request) {
//		User customer = userService.getUserFromToken(request.getHeader("Authorization"));
//		return orderService.addAllBooking(id, customer);
//	}
//
//	@PostMapping("/delivery/add")
//	public ResponseEntity<OrderDTO> addDelivery(@RequestBody OrderDTO orderDto, HttpServletRequest request) {
//		User customer = userService.getUserFromToken(request.getHeader("Authorization"));
//		return orderService.addAllOrders(orderDto, customer);
}
