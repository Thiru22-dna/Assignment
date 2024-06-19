package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductMetadata;
import com.example.demo.model.ShopperProduct;
import com.example.demo.service.DataIngestionService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class CombinedController {
	
	@Autowired
	private DataIngestionService dataIngestionService;
	
	@Autowired
	private ProductService productService;
	
	//Endpoint for ingesting shopper product data
	@PostMapping("/data/ingest/shopper")
	public ResponseEntity<ShopperProduct> ingestShopperProduct(@RequestBody
			ShopperProduct shopperProduct){
		ShopperProduct shopper=dataIngestionService.ingestShopperProduct(shopperProduct);
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(shopper);
		}catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
 	
	@PostMapping("/data/ingest/metadata")
	public ResponseEntity<ProductMetadata> ingestProductMetadata(@RequestBody 
			                        ProductMetadata productMetadata){
		
		ProductMetadata meta= dataIngestionService.ingestProductMetadata(productMetadata);
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(meta);
		}catch(Exception e) {
		    
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Endpoint for retrieving products
//	@GetMapping("/products")
//	public ResponseEntity<List<ProductMetadata>> getProducts(
//			@RequestParam String shopperId,
//			@RequestParam(required = false) String category,
//			@RequestParam(required = false) String brand,
//			@RequestParam(defaultValue = "10") int limit){
//		
//		List<ProductMetadata> products = productService.getProducts(shopperId, category, brand, limit);
//		return ResponseEntity.ok(products);
//	}

}
