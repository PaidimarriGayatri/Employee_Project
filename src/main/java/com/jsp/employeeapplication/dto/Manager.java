package com.jsp.employeeapplication.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Manager {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Name;
	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private String bloodgroup;
	private String availabilty;
	@JsonIgnore
	@OneToMany(mappedBy="manager")
	private List<Employee> employee;
	
}
