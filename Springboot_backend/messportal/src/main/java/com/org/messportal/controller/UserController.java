package com.org.messportal.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.org.messportal.config.JwtRequest;
import com.org.messportal.config.JwtResponse;
import com.org.messportal.config.JwtTokenUtil;
import com.org.messportal.config.JwtUserDetailsService;
import com.org.messportal.dto.UserDTO;
import com.org.messportal.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/messportal/users")
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@GetMapping("/reg")
	public ResponseEntity<List<UserDTO>> findAllRigisteredUsers() {
		return userservice.findAllUsers();
	}

	@PostMapping("/reg/add")
	public ResponseEntity<UserDTO> addAllRegisteredUser(@RequestBody UserDTO userDto) {
		System.out.println("employee " + userDto.toString());
		return userservice.createUserForRegistration(userDto);
	}

//	@PostMapping("/login")
//	public String login(@RequestBody UserDTO userDto) {
//		String str= userservice.login(userDto.getEmail(), userDto.getPassword());
//		String token =str;
//		if(str=="valid user")
//		{
//			token= JwtUtil.generateToken(userDto.getUserName());
//	        return token;
//		}
//			
//        else
//        	return str;	
//	}

//	@PostMapping("/login")
//	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto) {
//		return userservice.login(userDto.getEmail(), userDto.getPassword());
//	}

	@GetMapping("reg/{id}")
	public ResponseEntity<List<UserDTO>> findUserById(@PathVariable int id) {
		return userservice.findUsersById(id);
	}

	@GetMapping("/vendors")
	public ResponseEntity<List<UserDTO>> findAllvendors() {
		return userservice.findAllvendors();
	}

//	@GetMapping("/address/{id}")
//	public ResponseEntity<Address> findAddressById(@PathVariable int id) {
//		return userservice.findAddressById(id);
//	}
//
//	@GetMapping("/address")
//	public ResponseEntity<List<Address>> findAllAddress() {
//		return userservice.findAllAddress();
//	}
//
//	@PostMapping("/address/add")
//	public ResponseEntity<Address> addAll(@RequestBody Address address) {
//		return userservice.addAlladdress(address);
//	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		// authenticate(authenticationRequest.getEmail(),
		// authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByEmailAndPassword(authenticationRequest.getEmail(),
				authenticationRequest.getPassword());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse("Bearer " + token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
					(Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8)))));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
