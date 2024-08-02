package com.jsp.employeeapplication.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.employeeapplication.util.ResponseStructure;


import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerEmployee {
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> sqlexception(SQLIntegrityConstraintViolationException e){
        ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setData(e.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("You can't perform this operation");
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(EmailWrongException.class)
	public ResponseEntity<ResponseStructure<String>> emailWrong(EmailWrongException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("entered the wrong email");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BloodGroupNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> bloodGroupWrong(BloodGroupNotPresentException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("entered the wrong blood Group");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	


	@ExceptionHandler(IdWrongException.class)
	public ResponseEntity<ResponseStructure<String>> idWrong(IdWrongException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("entered the wrong email");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(IdNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> wrongId(IdNotPresentException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("entered the wrong Id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ManagerNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> wrongId(ManagerNotPresentException e) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setData(e.getMsg());
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("entered the wrong manager id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ManagerTableEmptyException.class)
	public ResponseEntity<ResponseStructure<String>> managertableempty(ManagerTableEmptyException m){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(m.getMsg());
		structure.setMessage("empty manager table");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeTableEmptyException.class)
	public ResponseEntity<ResponseStructure<String>> Employeetableempty(EmployeeTableEmptyException ee){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(ee.getMsg());
		structure.setMessage("Empty employee table");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
