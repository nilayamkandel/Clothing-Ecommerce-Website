package com.springproject.ClothingEcommerce.service;

import java.util.List;

import com.springproject.ClothingEcommerce.model.Category;

public interface ICategoryService {
	
	void addCategory(Category category);
	
	void deleteCategory(int id);
	
	void editCategory(Category category);
	
	List<Category> getAllCategory();
	
	Category getCategoryById(int id);
}
