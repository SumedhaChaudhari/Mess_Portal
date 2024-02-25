package com.org.messportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.messportal.dto.SubscriptionDTO;
import com.org.messportal.entity.User;
import com.org.messportal.entity.UserSubscription;

public interface UserSubscriptionService {

	public ResponseEntity<List<String>> findAllUserSubscriptions();

	public ResponseEntity<UserSubscription> findUserSubscriptionById(int id);

	public ResponseEntity<SubscriptionDTO> addAllRoles(SubscriptionDTO subscriptionDTO, User customer);

}
