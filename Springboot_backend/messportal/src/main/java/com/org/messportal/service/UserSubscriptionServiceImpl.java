package com.org.messportal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.messportal.dao.UserSubscriptionRepository;
import com.org.messportal.dto.SubscriptionDTO;
import com.org.messportal.entity.User;
import com.org.messportal.entity.UserSubscription;
import com.org.messportal.util.ACTIVE;
import com.org.messportal.util.SUBSCRIBE_TYPE;

@Service
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

	@Autowired
	private UserSubscriptionRepository userSubscriptionRepository;

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@Override
	public ResponseEntity<List<String>> findAllUserSubscriptions() {
		// TODO Auto-generated method stub
		List<String> usersubscribe = userSubscriptionRepository.findAllSubscriptions();

		return ResponseEntity.ok(usersubscribe);
	}

	@Override
	public ResponseEntity<UserSubscription> findUserSubscriptionById(int id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(userSubscriptionRepository.findById(id).orElse(null));
	}

	@Override
	public ResponseEntity<SubscriptionDTO> addAllRoles(SubscriptionDTO subscriptionDTO, User customer) {
		// TODO Auto-generated method stub

		UserSubscription userSubscription = userSubscriptionRepository
				.save(getSubscriptionFromSubscriptionDTO(subscriptionDTO, customer));
		return ResponseEntity.ok(subscriptionDTO);
	}

	private UserSubscription getSubscriptionFromSubscriptionDTO(SubscriptionDTO subscriptionDTO, User customer) {
		// TODO Auto-generated method stub

		UserSubscription userSubscription = new UserSubscription();

		userSubscription.setActive(ACTIVE.ACTIVE);
		userSubscription.setSubscriptionType(subscriptionDTO.getSubscriptionType());
		userSubscription.setTotalAmount(subscriptionDTO.getTotalAmount());
		userSubscription.setUpdatedTime(LocalDateTime.now());

		if (subscriptionDTO.getSubscriptionType() == SUBSCRIBE_TYPE.WEEKLY) {
			userSubscription.setSubscriptionExpireDate(LocalDateTime.now().toLocalDate().plusDays(7));
		} else {
			userSubscription.setSubscriptionExpireDate(LocalDateTime.now().toLocalDate().plusDays(30));
		}
		userSubscription.setMenuDetail(menuService.findMenuById(subscriptionDTO.getMenuId()));
		userSubscription.setUser(userService.findUserById(customer.getId()));

		return userSubscription;
	}

}
