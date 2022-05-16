package com.market.market.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.market.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByEmail(String email);
	
	// Customer notMappableMethodName(String something);
}
