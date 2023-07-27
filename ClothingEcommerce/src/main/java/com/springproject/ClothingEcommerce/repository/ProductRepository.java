package com.springproject.ClothingEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.ClothingEcommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
