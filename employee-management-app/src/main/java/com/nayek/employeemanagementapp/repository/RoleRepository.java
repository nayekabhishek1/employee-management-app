package com.nayek.employeemanagementapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayek.employeemanagementapp.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,String>{

}
