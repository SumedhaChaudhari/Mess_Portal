package com.org.messportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from users a where a.id= :id", nativeQuery = true)
	List<User> findUById(int id);

	User findUserByEmailAndPassword(String email, String password);

	@Query(value = "select * from users a where a.id in (select vendor_id from menu_details) and  a.role_id=2 ", nativeQuery = true)
	List<User> findAllvendors();

	@Query(value = "select * from users a where a.role_id=1", nativeQuery = true)
	List<User> findAllCustomers();

	User findUserByEmail(String email);

}
