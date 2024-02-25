package com.org.messportal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.messportal.dao.MenuDetailsRepository;
import com.org.messportal.dto.MenuDTO;
import com.org.messportal.entity.MenuDetail;
import com.org.messportal.entity.User;
import com.org.messportal.util.ACTIVE;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDetailsRepository menuDetailsRepository;

	@Autowired
	private UserService UserService;

	@Override
	public ResponseEntity<List<MenuDTO>> findAllmenudetails(int vendorId) {
		// TODO Auto-generated method stub

		List<MenuDetail> menuDetails = menuDetailsRepository.findMenuDetailByVendorId(vendorId);
		List<MenuDTO> menuDto = new ArrayList<MenuDTO>();
		if (menuDetails != null && !menuDetails.isEmpty()) {
			menuDetails.forEach(menu -> {
				MenuDTO menuD = getMenuDTOFromMenuDetails(menu);
				menuDto.add(menuD);
			});
			return ResponseEntity.ok(menuDto);
		}
		return null;
	}

	@Override
	public MenuDTO getMenuDTOFromMenuDetails(MenuDetail menu) {
		if (menu != null) {
			MenuDTO menuD = new MenuDTO();
			menuD.setId(menu.getId());
			menuD.setType(menu.getType());
			menuD.setDescription(menu.getDescription());
			menuD.setPrice(menu.getPrice());
			menuD.setUpdatedTime(menu.getUpdatedTime());
			menuD.setExpireDate(menu.getExpireDate());
			System.out.println(menu.getUser().getId());
			menuD.setVendorId(menu.getUser().getId());

			return menuD;
		} else {
			return null;
		}
	}

	@Override
	public MenuDetail findMenuById(int id) {

		return menuDetailsRepository.findById(id).orElse(null);

	}

	@Override
	public ResponseEntity<MenuDTO> findMenuDetailById(int id) {
		// TODO Auto-generated method stub

		MenuDetail menudetail = menuDetailsRepository.findById(id).orElse(null);

		MenuDTO menuDto = getMenuDTOFromMenuDetails(menudetail);

		return ResponseEntity.ok(menuDto);
	}

	@Override
	public ResponseEntity<MenuDTO> addAllmenudetails(MenuDTO menuDTO, User vendor) {
		// TODO Auto-generated method stub

		MenuDetail menuDetail = menuDetailsRepository.save(getMenuFromMenuDTO(menuDTO, vendor));
		// MenuDTO menudto = getMenuDTOFromMenuDetails(menuDetail);

		return ResponseEntity.ok((menuDTO));
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return UserService.findUserById(id);
	}

	@Override
	public MenuDetail getMenuFromMenuDTO(MenuDTO menuDto, User vendor) {
		MenuDetail menuDetail = new MenuDetail();
		menuDetail.setActive(ACTIVE.ACTIVE);
		menuDetail.setType(menuDto.getType());
		menuDetail.setDescription(menuDto.getDescription());
		menuDetail.setPrice(menuDto.getPrice());
		menuDetail.setUpdatedTime(LocalDateTime.now());
		menuDetail.setExpireDate(menuDto.getExpireDate());
		// System.out.println("Vendor id is" + menuDto.getVendorId());
		menuDetail.setUser(findUserById(vendor.getId()));

		return menuDetail;
	}
}
