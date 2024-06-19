package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ProductMetadata;
import com.example.demo.model.Shelf;
import com.example.demo.model.ShopperProduct;
import com.example.demo.repository.ProductMetadataRepository;
import com.example.demo.repository.ShopperProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ShopperProductRepository shopperProductRepository;
	
	@Autowired
	private ProductMetadataRepository productMetadataRepository;
	
		
	public List<ProductMetadata> getProducts(String shopperId,String category,String brand,int limit){
		
		List<ShopperProduct> shopperProducts = shopperProductRepository.findByShopperId(shopperId);
		List<ProductMetadata> filteredProducts = new ArrayList<>();
		List<Shelf> shelf=shopperProducts.stream().flatMap(x->x.getShelf().stream()).collect(Collectors.toList());
		for(Shelf shopperProduct:shelf) {
			
			ProductMetadata productMetadata = productMetadataRepository.findById(shopperProduct.getProductId()).orElse(null);
			if(productMetadata!=null) {
				if((category==null || productMetadata.getCategory().equals(category)) && 
						(brand==null || productMetadata.getBrand().equals(brand))) {
					filteredProducts.add(productMetadata);
				}
			}
		}
		
		return filteredProducts.stream().limit(limit).collect(Collectors.toList());
	}

}
