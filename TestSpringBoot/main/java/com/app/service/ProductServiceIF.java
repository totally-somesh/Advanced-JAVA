package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Product;


public interface ProductServiceIF {

	public List<Product> procureAllProducts();
	
}
