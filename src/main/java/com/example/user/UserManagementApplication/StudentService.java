package com.example.user.UserManagementApplication;

import org.springframework.data.domain.Page;

public interface StudentService {

	Page<Student> getAllUsersByPages(int pageNumber,int numberOfElementsPerPage);

	
}
