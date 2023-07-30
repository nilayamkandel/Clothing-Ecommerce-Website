package com.springproject.ClothingEcommerce.service;

import java.util.List;

import com.springproject.ClothingEcommerce.model.Product;

public interface IProductService {
	
	void addProduct(Product product);
	
	void updateProduct(Product product);
	
	void deleteProduct(Long id);
	
	Product findProductById(Long id);
	
	List<Product> findAllProduct();
	
	List<Product> findAllProductsForAdmin();

	List<Product> findProductByCategoryId(Integer categoryId);

	Product findProductByIdForAdmin(Long id);
}

