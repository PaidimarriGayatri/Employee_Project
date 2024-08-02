package com.jsp.employeeapplication.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.employeeapplication.dto.Manager;


public interface Managerrepo  extends JpaRepository<Manager, Integer>{

	@Query("select a from Manager a where a.id=?1")
	Optional<Manager> findById(int id);

	@Query("select a from Manager a where a.availabilty='AVAILABLE'")
	List<Manager> fetchAllBloodGroup();
	
}
