package com.example.user.UserManagementApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Page<Student> getAllUsersByPages(int pageNumber, int numberOfElementsPerPage) {
		// TODO Auto-generated method stub
		 return studentRepository.findAll(PageRequest.of(pageNumber,numberOfElementsPerPage));
	}
	
	
	
}
