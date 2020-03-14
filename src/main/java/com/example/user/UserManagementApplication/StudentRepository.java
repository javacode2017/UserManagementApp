package com.example.user.UserManagementApplication;

import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {

	

	
}
