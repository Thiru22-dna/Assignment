package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductMetadata;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class DataIngestionController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<ProductMetadata>> getProducts(
			@RequestParam String shopperId,
			@RequestParam(required=false) String category,
			@RequestParam(required=false) String brand,
			@RequestParam(defaultValue = "10") int limit){
		
		List<ProductMetadata> products = productService.getProducts(shopperId, 
				category, brand, limit);
		return ResponseEntity.ok(products);
		
		
	}

}
