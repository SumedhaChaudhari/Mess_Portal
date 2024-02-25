package com.org.messportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query(value = "select u.user_name,u.user_phone from users u inner join orders o where u.id=o.customer_id and o.delivery_type=0", nativeQuery = true)
	List<String> findOrdersBooked();

	@Query(value = " select b.user_name, b.user_phone, b.address_description from(select u.user_name,u.user_phone,u.id, a.address_description from users u inner join addresses a where u.id=a.user_id) b inner join orders o where o.id=b.id and o.delivery_type=1;", nativeQuery = true)
	List<String> findOrdersDelivered();

}
