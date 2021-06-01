package com.alexyom.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.spring.models.Category;
import com.alexyom.spring.models.Product;
import com.alexyom.spring.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	// Get All
	public List<Category> getAllCategories() {
		return this.cRepo.findAll();
	}
	
	//Find by ID
	public Category findById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	//Create
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	//Update a Category
	public Category updateCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	//Get Category not added to Product
	public List<Category> categoriesNotAdded(Product product) {
		return this.cRepo.findByProductsNotContains(product);
	}
	
	//Add Product to Category
	public void addProduct(Product product, Category category) {
		List<Product> products = category.getProducts();
		System.out.println(product);
		products.add(product);
		this.cRepo.save(category);
	}
}
