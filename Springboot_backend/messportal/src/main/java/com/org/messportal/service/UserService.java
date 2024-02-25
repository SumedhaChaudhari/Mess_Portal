package com.org.messportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.org.messportal.dto.AddressDTO;
import com.org.messportal.dto.UserDTO;
import com.org.messportal.entity.Address;
import com.org.messportal.entity.Role;
import com.org.messportal.entity.User;

public interface UserService {
	public ResponseEntity<List<UserDTO>> findAllUsers();

	public ResponseEntity<List<UserDTO>> findUsersById(int id);

	public ResponseEntity<User> addAllUser(User user);

	public ResponseEntity<List<Address>> findAllAddress();

	public ResponseEntity<Address> findAddressById(int id);

	public ResponseEntity<Address> addAlladdress(Address address);

	public User getUserFromUserDTO(UserDTO userDto);

	public ResponseEntity<UserDTO> createUserForRegistration(UserDTO userDto);

	public User findUserById(int id);

	public Role findRolesById(int id);

	public List<AddressDTO> findAllAddresses(int userId);

	public ResponseEntity<UserDTO> login(String email, String password);

	public ResponseEntity<List<UserDTO>> findAllvendors();

	public Address findAByUserId(int id);

	public ResponseEntity<List<UserDTO>> findAllCustomers();

	public Optional<User> findUserByEmailId(String email);

	public Optional<User> findUserByEmailAndPassword(String email, String password);

	public User getUserFromToken(String requestTokenHeader);

	public UserDTO getUserDTOFromUser(User useru);

}
