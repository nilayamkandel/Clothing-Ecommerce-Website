package com.springproject.ClothingEcommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springproject.ClothingEcommerce.model.Category;
import com.springproject.ClothingEcommerce.repository.CategoryRepository;
import com.springproject.ClothingEcommerce.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public void addCategory(Category category) {
		catRepo.save(category);
		
	}

	@Override
	public void deleteCategory(int id) {
		catRepo.deleteById(id);
		
	}

	@Override
	public void editCategory(Category category) {
		catRepo.save(category);
		
	}

	@Override
	public List<Category> getAllCategory() {
		return catRepo.findAll();
	}

	@Override
	public Category getCategoryById(int id) {		
		return catRepo.findById(id).get();
	}
	
	

}
