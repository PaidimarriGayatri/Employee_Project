package com.jsp.employeeapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.employeeapplication.dao.ManagerDao;
import com.jsp.employeeapplication.dto.Manager;

import com.jsp.employeeapplication.exception.IdNotPresentException;
import com.jsp.employeeapplication.exception.IdWrongException;
import com.jsp.employeeapplication.exception.ManagerNotPresentException;
import com.jsp.employeeapplication.exception.ManagerTableEmptyException;
import com.jsp.employeeapplication.util.ResponseStructure;

@Service
public class Managerservice {

	@Autowired
	private ManagerDao dao;
	
	
	//save
	public ResponseEntity<ResponseStructure<Manager>> savemanager(Manager  manager){
		
		ResponseStructure<Manager> structure=new ResponseStructure<Manager>();
		Manager db=dao.savemanager(manager);
		structure.setData(manager);
		structure.setMessage("Manager saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return  new ResponseEntity<ResponseStructure<Manager>>(structure,HttpStatus.CREATED);
		
	}
	
	//update
	

	public ResponseEntity<ResponseStructure<Manager>> updateManag(Manager manager){
		Manager db=dao.updatemana(manager);
		if(db!=null) {
			ResponseStructure<Manager> structure=new ResponseStructure<Manager>();
			structure.setData(db);
			structure.setMessage("manager update successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<Manager>>(structure,HttpStatus.FOUND);
		}
	     throw new IdNotPresentException();
	}
	
	//delete
	
	public ResponseEntity<ResponseStructure<Manager>> deletebyId(int id){
		Manager db= dao.deletebyid(id);
		if(db!=null) {
			ResponseStructure<Manager> structure=new ResponseStructure<Manager>();
			structure.setData(db);
			structure.setMessage("Manager deleted successfully ");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(structure,HttpStatus.FOUND);
		}
		throw new ManagerNotPresentException();
	}
	
	//fetchbyid
	public ResponseEntity<ResponseStructure<Manager>> fetchbyId(int id){
		Manager db=dao.fetchBymanagerId(id);
		if(db!=null) {
			ResponseStructure<Manager> structure=new ResponseStructure<Manager>();
			structure.setData(db);
			structure.setMessage("Manager fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>> (structure,HttpStatus.FOUND);
		}
		throw new IdWrongException();
		
	}
	
	//fetchall
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchAllBllodgroup() {
		List<Manager> db = dao.fetchallBloodgroup();
		if (db.size() != 0) {
			ResponseStructure<List<Manager>> structure = new ResponseStructure<List<Manager>>();
			structure.setData(db);
			structure.setMessage("All managers are fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Manager>>>(structure, HttpStatus.FOUND);
		}
		throw new ManagerTableEmptyException();
	}
}
	
	

