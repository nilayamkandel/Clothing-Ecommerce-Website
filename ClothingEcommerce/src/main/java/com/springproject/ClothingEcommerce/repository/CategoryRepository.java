package com.springproject.ClothingEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ClothingEcommerce.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
