package com.springproject.ClothingEcommerce.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ClothingEcommerce.model.Product;
import com.springproject.ClothingEcommerce.repository.ProductRepository;
import com.springproject.ClothingEcommerce.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ProductRepository proRepo;

	@Override
	public void addProduct(Product product) {
		proRepo.save(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		proRepo.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		proRepo.deleteById(id);
	}

	@Override
	public Product findProductById(Long id) {
		
		return proRepo.findById(id).get();
	}

	@Override
	public List<Product> findAllProduct() {
		
		return null;
	}

	@Override
	public List<Product> findAllProductsForAdmin() {
		
		return proRepo.findAll(); 
	}

	@Override
	public List<Product> findProductByCategoryId(Integer categoryId) {
		
		return null;
	}

	@Override 
	public Product findProductByIdForAdmin(Long id) {		
		return null;
	}

}

