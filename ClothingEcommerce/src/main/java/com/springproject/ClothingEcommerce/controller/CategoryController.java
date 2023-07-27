package com.springproject.ClothingEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/list")
	public String getCategoryList(Model model) {
		model.addAttribute("catlist",catService.getAllCategory());
		return "categorylist";
	}
	
	@GetMapping("/edit")
	public String getCategoryEdit(@RequestParam int id,Model model) {
		model.addAttribute("catedit",catService.getCategoryById(id));
		return "categoryedit";
	}
	
	@PostMapping("/update")
	public String postCategoryEdit(@ModelAttribute Category category) {
		catService.editCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/delete")
	public String getCategoryDelete(@RequestParam int id) {
		catService.deleteCategory(id);
		return "redirect:/category/list";
	}
	
	
}
