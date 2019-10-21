package com.example.springapi.springapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapi.springapi.model.Student;
import com.example.springapi.springapi.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/")
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/")
	public Student tambahStudent(@Valid @RequestBody Student student){
		return studentRepository.save(student);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") int id, @Valid @RequestBody Student detailStudent){
		Student student = studentRepository.findOne(id);
		if (student == null){
			return ResponseEntity.notFound().build();
		}
		student.setNama(detailStudent.getNama());
		student.setKelas(detailStudent.getKelas());
		student.setTelepon(detailStudent.getTelepon());
		student.setEmail(detailStudent.getEmail());
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/{id}")
	public String deleteBuku(@PathVariable (value = "id") Integer id){
		Student student = studentRepository.findOne(id);
		String result = "";
		if (student == null) {
			result = "id " +id+" tidak ditemukan";
			return result;
		}
		result = "id " +id+" berhasil dihapus";
		studentRepository.delete(id);
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Integer id){
	Student buku = studentRepository.findOne(id);
	if(buku == null)
	return ResponseEntity.notFound().build();
	return ResponseEntity.ok().body(buku);
	}
	
}
