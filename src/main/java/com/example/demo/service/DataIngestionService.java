package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductMetadata;
import com.example.demo.model.ShopperProduct;
import com.example.demo.repository.ProductMetadataRepository;
import com.example.demo.repository.ShopperProductRepository;

@Service
public class DataIngestionService {

	@Autowired
	private ShopperProductRepository shopperProductRepository;
	
	@Autowired
	private ProductMetadataRepository productMetadataRepository;
	
	public ShopperProduct ingestShopperProduct(ShopperProduct shopperProduct) {
		
		return shopperProductRepository.save(shopperProduct);
	}
	
	
	public ProductMetadata ingestProductMetadata(ProductMetadata productMetadata) {
		
		return productMetadataRepository.save(productMetadata);
	}
	

}


