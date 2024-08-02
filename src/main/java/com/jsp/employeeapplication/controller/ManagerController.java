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

import com.jsp.employeeapplication.dto.Manager;
import com.jsp.employeeapplication.service.Managerservice;
import com.jsp.employeeapplication.util.ResponseStructure;



@RestController
public class ManagerController {
	
	@Autowired
	private Managerservice service;
	
	
	@PostMapping("/savemanager")
	public ResponseEntity<ResponseStructure<Manager>> saveEmployee(@RequestBody Manager manager){
		return service.savemanager(manager);
		
	}
	
	@PutMapping("/updatemanager")
	public ResponseEntity<ResponseStructure<Manager>> updatemanager(@RequestBody Manager manager){
		return service.updateManag(manager);
		
	}
	
	@DeleteMapping("/deletemanager")
	public ResponseEntity<ResponseStructure<Manager>> delete(@RequestParam int id){
		return service.deletebyId(id);
	}
	
	@GetMapping("/fetchid")
	public ResponseEntity<ResponseStructure<Manager>> fetchbyId(@RequestParam int id){
		return service.fetchbyId(id);
		
	}
	@GetMapping("/fetchAllBloodgroup")
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchAllbloodgroup() {
		return service.fetchAllBllodgroup();
	}

}
