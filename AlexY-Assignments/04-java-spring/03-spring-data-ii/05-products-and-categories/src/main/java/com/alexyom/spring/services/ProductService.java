package com.alexyom.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.spring.models.Category;
import com.alexyom.spring.models.Product;
import com.alexyom.spring.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	// Get All
	public List<Product> getAllProducts() {
		return this.pRepo.findAll();
	}
	
	//Find by ID
	public Product findById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//Update a Product
	public Product updateProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//Get Category Not Added to Product
	public List<Product> getUniqueCategory(Category category) {
		return this.pRepo.findByCategoriesNotContains(category);
	}
	
	//Add Category to Product
	public void addCategory(Category category, Product product) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		this.pRepo.save(product);
	}
}
