package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductServiceIF;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductServiceIF productServiceInstance;

	public ProductController() {

		System.out.println(" -----< Inside ProductConstructor >----- ");
	}

	@GetMapping
	public List<Product> getAllProducts() {

		System.out.println(" -----< Inside getAllProduct Method >----- ");
		
		return productServiceInstance.procureAllProducts();

	}
}
