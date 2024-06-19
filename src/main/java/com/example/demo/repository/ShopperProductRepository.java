package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.ShopperProduct;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProduct,Long>{
	
	List<ShopperProduct> findByShopperId(String shopperId);
	

}
