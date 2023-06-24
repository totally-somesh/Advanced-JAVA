package com.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class AllProductTestCase {

	@Autowired
	private ProductRepositoryIF productRepositoryInstance;
	
	public AllProductTestCase() {
		
		System.out.println(" -----< Inside AllProduct Test Case >-----");
		
	}
	
	//String pName, Integer quantity, Double price, double salary, String description
	
	@Test
	void testAllProducts() {
	
		List<Product> productList = List.of(
				
				new Product("Bread",20,45.00,"Fresh & Healthy"),
				new Product("Butter",25,60.00,"Buttery & Pure"),
				new Product("Honey",10,200.00,"Healthy & Sweet"),
				new Product("Cheese",30,150.00,"Cheesy & Crispy"),
				new Product("Curd",5,40.00,"Creamy Curd")				
				);
	
		List populatedList = productRepositoryInstance.saveAll(productList);
	
		assertEquals(5, populatedList.size());	
	}

}
