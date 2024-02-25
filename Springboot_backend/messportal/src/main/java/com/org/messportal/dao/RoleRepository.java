package com.org.messportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.messportal.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
