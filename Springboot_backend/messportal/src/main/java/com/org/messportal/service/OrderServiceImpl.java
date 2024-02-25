package com.org.messportal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.messportal.dao.OrderRepository;
import com.org.messportal.dto.OrderDTO;
import com.org.messportal.entity.Address;
import com.org.messportal.entity.MenuDetail;
import com.org.messportal.entity.Order;
import com.org.messportal.entity.User;
import com.org.messportal.util.ORDER_STATUS;
import com.org.messportal.util.StringRandom;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<Order> findOrderById(int id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(orderRepository.findById(id).orElse(null));
	}

	@Override
	public ResponseEntity<List<String>> findAllBookingOrders() {
		List<String> user = orderRepository.findOrdersBooked();

//		List<User> user = orderRepository.findOrdersBooked();
//		List<UserDTO> userDto = new ArrayList<UserDTO>();
//		if (user != null && !user.isEmpty()) {
//			user.forEach(useru -> {
//				UserDTO userD = userService.getUserDTOFromUser(useru);
//				userDto.add(userD);
//
//			});
//			return ResponseEntity.ok(userDto);
//		}
		return ResponseEntity.ok(user);
	}

	@Override
	public ResponseEntity<List<String>> findAllDeliveryOrders() {

		List<String> user = orderRepository.findOrdersDelivered();

//		List<UserDTO> userDto = new ArrayList<UserDTO>();
//		if (user != null && !user.isEmpty()) {
//			user.forEach(useru -> {
//				UserDTO userD = userService.getUserDTOFromUser(useru);
//				userDto.add(userD);
//
//			});
//			return ResponseEntity.ok(userDto);
		return ResponseEntity.ok(user);

	}

//	@Override
//	public ResponseEntity<Order> addAllRoles(Order order) {
//		// TODO Auto-generated method stub
//		return ResponseEntity.ok(orderRepository.save(order));
//	}

	@Override
	public ResponseEntity<OrderDTO> addAllOrders(OrderDTO orderDto, User customer) {
		// TODO Auto-generated method stub
		Order order = orderRepository.save(getOrderfromOrderDTO(orderDto, customer));

		return ResponseEntity.ok(orderDto);

	}

	private Order getOrderfromOrderDTO(OrderDTO orderDto, User customer) {
		// TODO Auto-generated method stub

		Order order = new Order();
		System.out.println(orderDto.toString());
		order.setDeliveryType(orderDto.getDeliveryType());
		order.setOrderCode(StringRandom.getRandomCode());
		order.setStatus(ORDER_STATUS.BOOKED);
		order.setUpdatedTime(LocalDateTime.now());
		MenuDetail menudetail = FindMenuById(orderDto.getMenuId());
		order.setMenuDetail(menudetail);
		order.setAddress(findAddressById(orderDto.getAddressId()));
		order.setUser1(findUserById(customer.getId()));
		order.setUser2(findUserById(orderDto.getVendorId()));

		return order;
	}

	private User findUserById(int customerId) {
		// TODO Auto-generated method stub
		return userService.findUserById(customerId);
	}

	private Address findAddressById(int addressId) {
		// TODO Auto-generated method stub
		return userService.findAByUserId(addressId);
	}

	private MenuDetail FindMenuById(int menuId) {
		// TODO Auto-generated method stub
		return menuService.findMenuById(menuId);
	}

}
