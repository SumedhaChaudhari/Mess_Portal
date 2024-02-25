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

import com.org.messportal.dto.SubscriptionDTO;
import com.org.messportal.entity.User;
import com.org.messportal.entity.UserSubscription;
import com.org.messportal.service.UserService;
import com.org.messportal.service.UserSubscriptionService;

@RestController
@RequestMapping("/messportal/subscription")
public class UserSubscriptionController {

	@Autowired
	private UserSubscriptionService userSubscriptionService;

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<UserSubscription> findUserSubscriptionById(@PathVariable int id) {
		return userSubscriptionService.findUserSubscriptionById(id);
	}

	@GetMapping("/get")
	public ResponseEntity<List<String>> findAllUserSubscriptions() {
		return userSubscriptionService.findAllUserSubscriptions();
	}

	@PostMapping("/add")
	public ResponseEntity<SubscriptionDTO> addAll(@RequestBody SubscriptionDTO subscriptionDTO,
			HttpServletRequest request) {
		User customer = userService.getUserFromToken(request.getHeader("Authorization"));
		return userSubscriptionService.addAllRoles(subscriptionDTO, customer);
	}

}
