package com.example.springapi.springapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
(name = "studentdetailstable")

@EntityListeners
(AuditingEntityListener.class)

public class Student implements Serializable {
	@Id
	@GeneratedValue
	(strategy = javax.persistence.GenerationType.AUTO)
	
	private Integer id;
	
	@NotBlank
	private String nama;
	
	@NotBlank
	private String kelas;
	
	@NotBlank
	private String telepon;
	
	@NotBlank
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
