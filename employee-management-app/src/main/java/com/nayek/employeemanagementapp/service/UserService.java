package com.nayek.employeemanagementapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nayek.employeemanagementapp.entities.Role;
import com.nayek.employeemanagementapp.entities.User;
import com.nayek.employeemanagementapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public User findUserByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	public boolean isUserExist(String email) {

		User user = userRepository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByNameLike("%" + name + "%");
	}

}
