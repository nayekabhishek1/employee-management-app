package com.nayek.employeemanagementapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nayek.employeemanagementapp.entities.Task;
import com.nayek.employeemanagementapp.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);

}
