package com.org.messportal.config;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.org.messportal.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.org.messportal.entity.User> user = userService.findUserByEmailId(username);
		if (user.isPresent()) {
			return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email id: " + username);
		}
	}

	public UserDetails loadUserByEmailAndPassword(String email, String password) throws UsernameNotFoundException {
		Optional<com.org.messportal.entity.User> user = userService.findUserByEmailAndPassword(email, password);
		if (user.isPresent()) {
			return new User(user.get().getEmail(), user.get().getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email id: " + email);
		}
	}
}
