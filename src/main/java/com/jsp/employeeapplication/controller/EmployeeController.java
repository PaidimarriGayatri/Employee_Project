package com.jsp.employeeapplication.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employeeapplication.dto.Employee;
import com.jsp.employeeapplication.service.EmployeeService;
import com.jsp.employeeapplication.util.ResponseStructure;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/saveemp")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee){
		return employeeservice.saveEmployee(employee);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> update(@RequestBody Employee employee){
		return employeeservice.update(employee);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Employee>> delete(@RequestParam int id){
		return employeeservice.deletebyId(id);
	}
	
	@GetMapping("/fetchempid")
	public ResponseEntity<ResponseStructure<Employee>> fetchbyId(@RequestParam int id){
		return employeeservice.fetchbyId(id);
		
	}
	
	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> fetchAll() {
		return employeeservice.fetchAll();
	}

	

}
