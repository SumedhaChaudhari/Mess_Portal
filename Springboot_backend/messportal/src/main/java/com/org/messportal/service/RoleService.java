package com.org.messportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.messportal.entity.Role;

public interface RoleService {
	public ResponseEntity<List<Role>> findAllRoles();

	public ResponseEntity<Role> addAllRoles(Role role);

	public ResponseEntity<Role> findRoleById(int id);

	public Role findById(int id);

}
