package com.org.messportal.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.org.messportal.dto.MenuDTO;
import com.org.messportal.entity.MenuDetail;
import com.org.messportal.entity.User;

public interface MenuService {
	public ResponseEntity<List<MenuDTO>> findAllmenudetails(int vendorId);

	public ResponseEntity<MenuDTO> findMenuDetailById(int id);

	public ResponseEntity<MenuDTO> addAllmenudetails(MenuDTO menuDTO, User vendor);

	public MenuDTO getMenuDTOFromMenuDetails(MenuDetail menu);

	public User findUserById(int id);

	public MenuDetail findMenuById(int id);

	public MenuDetail getMenuFromMenuDTO(MenuDTO menuDto, User vendor);

}
