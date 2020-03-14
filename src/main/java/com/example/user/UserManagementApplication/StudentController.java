package com.example.user.UserManagementApplication;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
	@GetMapping("/load")
	public List<Student> getData(){
		List<Student> list = studentRepository.findAll();
		return list;
		
	}
	@GetMapping("/load/{sid}")
	public Optional<Student>  getStudentById(@PathVariable(value = "sid") String  sid) {
		Optional<Student> student = studentRepository.findById(sid);
		return student;
		
	}
	@PutMapping("/update/{sid}")
	public ResponseEntity<Student> updateStudent(@PathVariable("sid") String sid,@RequestBody Student student) throws ResourceNotFoundException{
		Student studentupdate = studentRepository.findById(sid).orElseThrow(()->new  ResourceNotFoundException("Resource not availble with "+sid));
		
		studentupdate.setSname(student.getSname());
		studentupdate.setSage(student.getSage());
		
		Student student2 = studentRepository.save(studentupdate);
		return ResponseEntity.ok(student2);
	}
	
	@DeleteMapping("/delete/{sid}")
	public void deleteStudent(@PathVariable("sid") String sid) {
		studentRepository.deleteById(sid);
		
	}
	
	 @GetMapping("/getAllUserByPages/{pageNumber}/{numberOfElementsPerPage}")
	    public Page<Student> getAllUserByPages(@PathVariable String pageNumber, @PathVariable String numberOfElementsPerPage){
	        return studentService.getAllUsersByPages(Integer.parseInt(pageNumber), Integer.parseInt(numberOfElementsPerPage));
	    }
}
