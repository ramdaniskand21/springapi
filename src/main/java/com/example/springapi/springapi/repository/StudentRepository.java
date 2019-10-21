package com.example.springapi.springapi.repository;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.springapi.springapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	//List<Student> findByName (String nama);

	Student findOne(Integer id);

	void delete(Integer id);

}
