package com.ssd.StudentSpringApp.controler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.ssd.StudentSpringApp.model.Student;
import com.ssd.StudentSpringApp.service.StudentService;


import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")

public class StudentControler {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Student student,BindingResult reerror){
		Map<String, String> errormap=new HashMap<String,String>();
		if(reerror.hasErrors()) {
			for(FieldError error:reerror.getFieldErrors()) {
				errormap.put(error.getField(),error.getDefaultMessage());
			}
			return new ResponseEntity<>(errormap,HttpStatus.BAD_REQUEST);
			
			}
		Student emp= studentService.createStudent(student);
		return new ResponseEntity<Student>(emp,HttpStatus.CREATED); 
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllEmployees(){
		List<Student> studentlist= studentService.getAllStudents();
		 return new ResponseEntity<List<Student>>(studentlist,HttpStatus.OK);
	}
	
	@GetMapping("/students/{studentId}")
	public ResponseEntity<Optional<Student>> getEmployee(@PathVariable Integer studentId){
		Optional<Student> student= studentService.getStudentById(studentId);
		  return new ResponseEntity<Optional<Student>>(student,HttpStatus.OK);
		 
	}
	@PutMapping("/students/{studentId}")
	public ResponseEntity<Student> updateEmploye(@PathVariable Integer studentId, @RequestBody Student student){
		studentService.updateStudent(student);
		return new ResponseEntity<Student>(HttpStatus.OK);
		
	}
	@DeleteMapping("/students/{studentId}")
	public ResponseEntity<Student> deleteEmploye(@PathVariable Integer studentId){
		studentService.deleteStudent(studentId);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}
