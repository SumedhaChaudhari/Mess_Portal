package com.org.messportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.UserSubscription;

@Repository
public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Integer> {

	@Query(value = "select u.user_name, u.user_phone, s.subscription_type,s.subscription_expire_date from users u inner join user_subscription s where u.id=s.customer_id", nativeQuery = true)
	List<String> findAllSubscriptions();

}
