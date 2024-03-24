package com.ssd.StudentSpringApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssd.StudentSpringApp.exceptions.EmailException;
import com.ssd.StudentSpringApp.model.Student;
import com.ssd.StudentSpringApp.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepo;
	
	public Student createStudent( Student employee){
		System.out.println("hi welcome");
		
		Student std=null;
		try {
		std=studentRepo.save(employee);
		}catch(Exception ex) {
			 throw new EmailException("Already Email  "+employee.getEmail()+" provided");
		}
		return std;
	}
	
	public List<Student> getAllStudents(){
		
		return studentRepo.findAll();
		
	}
	public Optional<Student> getStudentById(Integer studentId) {
	return	studentRepo.findById(studentId);
	}
		 
	
	public void updateStudent(Student student) {
		studentRepo.saveAndFlush(student);
	}
	
	public void deleteStudent(Integer studentId) {
		
		studentRepo.deleteById(studentId);;
	}

}
