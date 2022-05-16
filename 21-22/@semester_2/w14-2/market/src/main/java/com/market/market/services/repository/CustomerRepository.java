package com.market.market.services.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.market.market.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByEmail(String email);
	
	@Query(
		value = "SELECT * FROM td_customers "+ 
				"WHERE first_name = ? AND last_name = ?", 
		nativeQuery = true
	)
	List<Customer> findByFullName(String fname, String lname);
}
