package com.nayek.employeemanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayek.employeemanagementapp.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {


	User findByEmail(String email);
	

}
