package com.jsp.employeeapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.employeeapplication.dto.Manager;
import com.jsp.employeeapplication.exception.IdNotPresentException;
import com.jsp.employeeapplication.repo.Managerrepo;

@Repository
public class ManagerDao {
	
	
	@Autowired
	private Managerrepo repo;
	
	//save 
	public Manager savemanager(Manager manager) {
		return repo.save(manager);
		
	}
	
	// update 

	
	public Manager updatemana(Manager manag) {
		
		Manager db=this.fetchBymanagerId(manag.getId());
		  if(db!=null) {
					if(manag.getEmail()!= null) {
						db.setEmail(manag.getEmail());
					}
					if(manag.getName()!=null) {
					       db.setName(manag.getName());
						
					}
					if(manag.getPassword()!=null) {
						db.setPassword(manag.getPassword());
						
					}
					if(manag.getAvailabilty()!=null) {
						db.setAvailabilty(manag.getAvailabilty());;
					}
				
					if(manag.getBloodgroup()!=null) {
						db.setAvailabilty(manag.getBloodgroup());
					}
					return repo.save(db);
				}else
					return null;
			}
	
	//deleteby id
	public Manager deletebyid(int id) {
		Optional<Manager> db=repo.findById(id);
		if(db.isEmpty()) {
			throw new IdNotPresentException();
		}
		else {
			repo.deleteById(id);;
			return db.get();
		}
	}

	// fetchbyid
	
	public Manager fetchBymanagerId(int id) {
		Optional<Manager> db=repo.findById(id);
		if(db.isPresent()) {
			return db.get();
		}
		else {
			 throw new IdNotPresentException();
		}
	}
	
	
	//fetch all
	
	public List<Manager> fetchallBloodgroup() {
		return  repo.fetchAllBloodGroup();
	}


}
