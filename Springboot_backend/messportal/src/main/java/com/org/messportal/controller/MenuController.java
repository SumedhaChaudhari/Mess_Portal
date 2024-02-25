package com.org.messportal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.messportal.dto.MenuDTO;
import com.org.messportal.entity.User;
import com.org.messportal.service.MenuService;
import com.org.messportal.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/messportal/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@GetMapping("/menudetails/{id}")
	public ResponseEntity<MenuDTO> findMenuDetailById(@PathVariable int id) {
		return menuService.findMenuDetailById(id);
	}

	@GetMapping("/menudetails/vendor/{vendorId}")
	public ResponseEntity<List<MenuDTO>> findAllMenudetails(@PathVariable int vendorId) {

		return menuService.findAllmenudetails(vendorId);
	}

	@PostMapping("/menudetails/add")
	public ResponseEntity<MenuDTO> addAll(@RequestBody MenuDTO menuDTO, HttpServletRequest request) {
		User vendor = userService.getUserFromToken(request.getHeader("Authorization"));
		return menuService.addAllmenudetails(menuDTO, vendor);
	}

}
