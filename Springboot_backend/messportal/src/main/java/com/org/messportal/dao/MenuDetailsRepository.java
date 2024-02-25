package com.org.messportal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.MenuDetail;

@Repository
public interface MenuDetailsRepository extends JpaRepository<MenuDetail, Integer> {

	@Query(value = "select * from Menu_Details a where a.vendor_Id= :vendorId", nativeQuery = true)
	List<MenuDetail> findMenuDetailByVendorId(int vendorId);

//	@Query(value = "UPDATE `messportal`.`orders` SET `order_code` = 'akdnks' WHERE (`id` = '8');\r\n"
//			+ "", nativeQuery = true)
//	List<MenuDetail> updateMenuBytype(int typeId);
}
