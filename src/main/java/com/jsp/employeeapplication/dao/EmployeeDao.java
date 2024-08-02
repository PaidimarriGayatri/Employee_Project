package com.jsp.employeeapplication.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.employeeapplication.dto.Employee;
import com.jsp.employeeapplication.exception.IdNotPresentException;
import com.jsp.employeeapplication.repo.Employeerepo;
@Repository
public class EmployeeDao  {

		@Autowired
		private Employeerepo employeerepo;
		
		//save
		public Employee saveEmployee(Employee employee) {
			return employeerepo.save(employee);
			
		}
		
		
		  //update
		public Employee update(Employee employee) {
					
			Employee db=this.fetchbyId (employee.getId());
			  if(db!=null) {
						if(employee.getEmail()!= null) {
							db.setEmail(employee.getEmail());
						}
						if(employee.getFirstName()!=null) {
							db.setFirstName(employee.getFirstName());
							
						}
						if(employee.getLastName()!=null) {
							db.setLastName(employee.getLastName());
							
						}
						if(employee.getPassword()!=null) {
							db.setPassword(employee.getPassword());
						}
						if(employee.getAvailabilty()!=null) {
							db.setAvailabilty(employee.getAvailabilty());
						}
						if(employee.getBloodgroup()!=null) {
							db.setBloodgroup(employee.getBloodgroup());
						}
						return employeerepo.save(db);
					}else
						return null;
				}
				
				
		
		//deletebyid
		public Employee deleteById(int id) {
		 Optional<Employee> db= employeerepo.findById(id);
		 if(db.isEmpty()){
			 throw new IdNotPresentException();
			 
		 }
		 else {
			 employeerepo.deleteById(id);
			 return db.get();
		 }
		
			
		}
		
		
		//fetchbyid
		public Employee fetchbyId(int id) {
			  Optional<Employee> db=employeerepo.findById(id);
			  if(db.isPresent()) {
				  return db.get();
			  }
			  else {
				  throw new IdNotPresentException();
			  }
			
		}
		
		
		// fetchby all
		public List<Employee> fetchAll() {
			return employeerepo.findAll();
		}
		

	}


