package com.market.market.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.market.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
