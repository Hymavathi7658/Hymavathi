package com.ssd.StudentSpringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ssd.StudentSpringApp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
