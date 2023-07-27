package com.springproject.ClothingEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.ClothingEcommerce.model.Category;
import com.springproject.ClothingEcommerce.service.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService catService;
	
	@GetMapping("/add")
	public String getCategory() {
		return "categoryadd";
	}
	
	@PostMapping("/add")
	public String postCategory(@ModelAttribute Category category) {
		catService.addCategory(category);
		return "categoryadd";
	}
	
}
