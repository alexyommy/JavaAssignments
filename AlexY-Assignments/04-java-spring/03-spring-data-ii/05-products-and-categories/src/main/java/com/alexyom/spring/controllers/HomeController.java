package com.alexyom.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alexyom.spring.models.Category;
import com.alexyom.spring.models.Product;
import com.alexyom.spring.services.CategoryService;
import com.alexyom.spring.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService cService;
	@Autowired
	private ProductService pService;
	
	//Home Page
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", cService.getAllCategories());
		model.addAttribute("products", pService.getAllProducts());
		return "index.jsp";
	}
	
	//Show Add Product Page
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	//Show Add Category Page
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	//Add New Product
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/products/new.jsp";
		}
		
		pService.createProduct(product);
		return "redirect:/products/new";
	}
	
	//Add New Category
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}
		
		cService.createCategory(category);
		return "redirect:/categories/new";
	}
	
	//Show Product
	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewModel) {
		Product product = this.pService.findById(id);
		
		List<Category> categories = product.getCategories();
		viewModel.addAttribute("product", product);
		viewModel.addAttribute("uniqueCategories", categories);
		
		List<Category> uniqueCategories = this.cService.categoriesNotAdded(product);
		viewModel.addAttribute("uniqueCategories", uniqueCategories);
		
		return "/products/show.jsp"; 
	}
	
	//Show Category
	@GetMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model viewModel) {
		Category category = this.cService.findById(id);
		
		List<Product> products = category.getProducts();
		viewModel.addAttribute("category", category);
		viewModel.addAttribute("products", products);
		
		List<Product> unAdded = this.pService.getUniqueCategory(category);
		viewModel.addAttribute("unAdded", unAdded);
		
		return "/categories/show.jsp"; 
	}
	
	//Add Category to Product
	@PostMapping("/product/addCategory")
	public String addCategoryToProduct(@RequestParam("category_id") Long catId, @RequestParam("product_id") Long prodId) {
		Product product = this.pService.findById(prodId);
		Category newCategory = this.cService.findById(catId);
		
		this.pService.addCategory(newCategory, product);
		
		return "redirect:/"; 
	}
	
	//Add Product to Category
	@PostMapping("/category/addProduct")
	public String addProductToCategory(@RequestParam("category_id") Long catId, @RequestParam("product_id") Long prodId) {
		Category category = cService.findById(catId);
		Product newProduct = pService.findById(prodId);
		
		this.cService.addProduct(newProduct, category);
		
		return "redirect:/"; 
	}
}
