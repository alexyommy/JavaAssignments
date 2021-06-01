package com.alexyom.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alexyom.spring.models.Category;
import com.alexyom.spring.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll(); // SELECT * FROM Products
	List<Product> findByCategoriesNotContains(Category category);
}
