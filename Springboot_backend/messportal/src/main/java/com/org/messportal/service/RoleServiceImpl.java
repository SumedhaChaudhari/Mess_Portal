package com.org.messportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.messportal.dao.RoleRepository;
import com.org.messportal.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<List<Role>> findAllRoles() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(roleRepository.findAll());
	}

	@Override
	public ResponseEntity<Role> addAllRoles(Role role) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(roleRepository.save(role));
	}

	@Override
	public ResponseEntity<Role> findRoleById(int id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(roleRepository.findById(id).orElse(null));
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id).orElse(null);
	}

}
