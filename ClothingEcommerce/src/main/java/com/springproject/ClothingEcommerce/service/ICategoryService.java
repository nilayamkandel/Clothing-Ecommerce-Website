package com.springproject.ClothingEcommerce.service;

import com.springproject.ClothingEcommerce.model.Category;

public interface ICategoryService {
	
	void addCategory(Category category);
	
	void deleteCategory(int id);
	
	void editCategory(Category category);
}
