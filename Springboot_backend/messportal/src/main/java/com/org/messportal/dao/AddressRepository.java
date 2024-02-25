package com.org.messportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	@Query(value = "select * from Addresses a where a.user_id= :userId", nativeQuery = true)
	List<Address> findAddressByUserId(int userId);

	@Query(value = "select * from Addresses a where a.user_id= :id and is_primary= 1", nativeQuery = true)
	Address findADDByUserId(int id);

}
