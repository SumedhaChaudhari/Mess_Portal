package com.org.messportal.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.messportal.config.JwtTokenUtil;
import com.org.messportal.dao.AddressRepository;
import com.org.messportal.dao.UserRepository;
import com.org.messportal.dto.AddressDTO;
import com.org.messportal.dto.UserDTO;
import com.org.messportal.entity.Address;
import com.org.messportal.entity.Role;
import com.org.messportal.entity.User;
import com.org.messportal.util.ACTIVE;
import com.org.messportal.util.StringRandom;

import io.jsonwebtoken.ExpiredJwtException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private RoleService roleService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public ResponseEntity<User> addAllUser(User user) {
		System.out.println("employee " + user);
		return ResponseEntity.ok(userRepository.save(user));
	}

	@Override
	public ResponseEntity<List<Address>> findAllAddress() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(addressRepository.findAll());
	}

	@Override
	public ResponseEntity<Address> addAlladdress(Address address) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(addressRepository.save(address));
	}

	@Override
	public ResponseEntity<Address> findAddressById(int id) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(addressRepository.findById(id).orElse(null));
	}

	@Override
	public ResponseEntity<UserDTO> createUserForRegistration(UserDTO userDto) {
		User user = userRepository.save(getUserFromUserDTO(userDto));
		userDto.setId(user.getId());
		return ResponseEntity.ok(userDto);
	}

	@Override
	public User getUserFromUserDTO(UserDTO userDto) {
		User user = new User();
		user.setActive(ACTIVE.ACTIVE);
		user.setEmail(userDto.getEmail());
		user.setUserName(userDto.getUserName());
		user.setEmailVerificationCode(StringRandom.getRandomCode());
		user.setUserIdProof(userDto.getUserIdProof());
		user.setUserPhone(userDto.getUserPhone());
		user.setPassword((Base64.getEncoder().encodeToString(userDto.getPassword().getBytes(StandardCharsets.UTF_8))));
		user.setRole(findRolesById(userDto.getRoleId()));
		List<Address> userAddresses = getAddressFromAddressDto(userDto.getAddresses());
		if (userAddresses != null && !userAddresses.isEmpty()) {
			userAddresses.stream().forEach(e -> e.setUser(user));
			user.setAddresses(userAddresses);
		}
		user.setUpdatedTime(LocalDateTime.now());
		return user;
	}

	public List<Address> getAddressFromAddressDto(List<AddressDTO> address) {
		List<Address> addresses = new ArrayList<>();
		if (address != null && !address.isEmpty()) {
			address.forEach(addre -> {
				Address addres = new Address();
				addres.setActive(ACTIVE.ACTIVE);
				addres.setAddressDescription(addre.getAddressDescription());
				addres.setIsPrimary(addre.getIsPrimary());
				addres.setUpdatedTime(LocalDateTime.now());
				addresses.add(addres);
			});
			return addresses;
		}
		return null;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public Role findRolesById(int id) {

		return roleService.findById(id);

	}

	@Override
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> user = userRepository.findAll();
		List<UserDTO> userDto = new ArrayList<UserDTO>();
		if (user != null && !user.isEmpty()) {
			user.forEach(useru -> {
				UserDTO userD = getUserDTOFromUser(useru);
				userDto.add(userD);

			});
			return ResponseEntity.ok(userDto);
		}
		return null;

	}

	@Override
	public Address findAByUserId(int id) {

		return addressRepository.findADDByUserId(id);

	}

	@Override
	public List<AddressDTO> findAllAddresses(int userId) {

		List<AddressDTO> addressDto = new ArrayList<AddressDTO>();

		List<Address> address = addressRepository.findAddressByUserId(userId);
		if (address != null && !address.isEmpty()) {
			address.forEach(arr -> {
				AddressDTO addressDt = new AddressDTO();
				addressDt.setId(arr.getId());
				addressDt.setActive(arr.getActive().toString());
				addressDt.setAddressDescription(arr.getAddressDescription());
				addressDt.setIsPrimary(arr.getIsPrimary());
				addressDto.add(addressDt);
			});
			return addressDto;
		}
		return null;
	}

	@Override
	public ResponseEntity<List<UserDTO>> findUsersById(int id) {
		// TODO Auto-generated method stub

		List<User> user = userRepository.findUById(id);
		List<UserDTO> userDto = new ArrayList<UserDTO>();
		if (user != null && !user.isEmpty()) {
			user.forEach(useru -> {
				UserDTO userD = getUserDTOFromUser(useru);
				userDto.add(userD);

			});
			return ResponseEntity.ok(userDto);
		}
		return null;
	}

	@Override
	public UserDTO getUserDTOFromUser(User useru) {
		if (useru != null) {
			UserDTO userD = new UserDTO();
			userD.setId(useru.getId());
			userD.setUserName(useru.getUserName());
			userD.setPassword(new String(Base64.getDecoder().decode(useru.getPassword()), StandardCharsets.UTF_8));
			userD.setUserPhone(useru.getUserPhone());
			userD.setEmail(useru.getEmail());
			userD.setActive(useru.getActive().toString());
			userD.setUserIdProof(useru.getUserIdProof());
			Role role = useru.getRole();
			userD.setRoleId(role.getId());
			userD.setRoleDescription(role.getRoleDescription());
			userD.setAddresses(findAllAddresses(useru.getId()));
			return userD;
		} else {
			return null;
		}
	}

//	@Override
//	public String login(String email, String password) {
//	User user=userRepository.findUserByEmailAndPassword(email,
//				Base64.getEncoder().encodeToString(password.getBytes()));
//	
//	if(user!=null)
//	{
//		return "valid user";
//	}
//	else
//	{
//		return "Invalid user";
//	}
//	}

	@Override
	public ResponseEntity<UserDTO> login(String email, String password) {
		return ResponseEntity.ok(getUserDTOFromUser(userRepository.findUserByEmailAndPassword(email,
				Base64.getEncoder().encodeToString(password.getBytes()))));
	}

	@Override
	public ResponseEntity<List<UserDTO>> findAllvendors() {
		// TODO Auto-generated method stub
		List<User> user = userRepository.findAllvendors();
		List<UserDTO> userDto = new ArrayList<UserDTO>();
		if (user != null && !user.isEmpty()) {
			user.forEach(useru -> {
				UserDTO userD = getUserDTOFromUser(useru);
				userDto.add(userD);

			});
			return ResponseEntity.ok(userDto);
		}
		return null;

	}

	@Override
	public ResponseEntity<List<UserDTO>> findAllCustomers() {
		// TODO Auto-generated method stub
		List<User> user = userRepository.findAllvendors();
		List<UserDTO> userDto = new ArrayList<UserDTO>();
		if (user != null && !user.isEmpty()) {
			user.forEach(useru -> {
				UserDTO userD = getUserDTOFromUser(useru);
				userDto.add(userD);

			});
			return ResponseEntity.ok(userDto);
		}
		return null;

	}

	@Override
	public Optional<User> findUserByEmailId(String email) {
		return Optional.of(userRepository.findUserByEmail(email));
	}

	@Override
	public Optional<User> findUserByEmailAndPassword(String email, String password) {
		return Optional.of(userRepository.findUserByEmailAndPassword(email,
				(Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)))));
	}

	@Override
	public User getUserFromToken(String requestTokenHeader) {
		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		System.out.println(requestTokenHeader);
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
				return userRepository.findUserByEmail(username);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			System.out.println("JWT Token does not begin with Bearer String");
		}
		return null;
	}
}