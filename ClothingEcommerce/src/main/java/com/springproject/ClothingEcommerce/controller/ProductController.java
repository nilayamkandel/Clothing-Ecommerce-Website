package com.springproject.ClothingEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springproject.ClothingEcommerce.model.Product;
import com.springproject.ClothingEcommerce.service.ICategoryService;
import com.springproject.ClothingEcommerce.service.IProductService;
import com.springproject.ClothingEcommerce.utils.FileUtil;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	public IProductService proService;
	
	@Autowired
	public ICategoryService catService;
	
	@Autowired
	public FileUtil fileutils;
	
	@GetMapping("/add")
	public String getProduct(Model model) {
		model.addAttribute("catlist", catService.getAllCategory());
		return "productadd";
	}
	
	@PostMapping("/add")
	public String postProduct(@ModelAttribute Product product, @RequestParam MultipartFile image, Model model) {
		
		if(!image.isEmpty()) {
					
					String imageName = image.getOriginalFilename();
					product.setImageName(imageName);
					fileutils.imageUpload(image);
					
					proService.addProduct(product);
					
					model.addAttribute("message", "Product added successfully !!");
					return "redirect:/product/add";		
		}
		return "productadd";
		
	}
	
	@GetMapping("/list")
	public String getProductList(Model model) {
		model.addAttribute("prodlist",proService.findAllProduct());
		return "productlist";	
	}
	
	 @GetMapping("/delete")
	 public String delete(@RequestParam long id) {
		 	
		 	proService.deleteProduct(id);
		 
		 return "redirect:/product/list";
	 }
	 
	 @GetMapping("/edit")
		public String editProduct(@RequestParam long id, Model model) {

			model.addAttribute("prodObject", proService.findProductById(id));
			model.addAttribute("catlist",catService.getAllCategory());
			
			return "productedit";
		}
	 
	 @PostMapping("/update")
	 public String update(@ModelAttribute Product product, @RequestParam MultipartFile image, Model model) {
		 
		 if(!image.isEmpty()) {
				
				String imageName = image.getOriginalFilename();
				product.setImageName(imageName);
				fileutils.imageUpload(image);
				
				proService.updateProduct(product);
				
				model.addAttribute("message", "Product added successfully !!");
				return "redirect:/product/list";		
	}
		 return "productedit";
		
	 }
	 
	 @GetMapping("/view")
	 public String view(@RequestParam long id, Model model) {
		 
		 model.addAttribute("prodObject",proService.findProductById(id));
		 model.addAttribute("catObject", catService.getAllCategory());
		 
		 return "productview";
	 }

}
