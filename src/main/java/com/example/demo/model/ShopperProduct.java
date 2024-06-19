package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shopperproduct")
public class ShopperProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String shopperId;
	List<Shelf> shelf;
	
	public ShopperProduct()
	{
		
	}
	
	public ShopperProduct(String shopperId, List<Shelf> shelf) {
		super();
		this.shopperId = shopperId;
		this.shelf = shelf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopperId() {
		return shopperId;
	}

	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}

	
	public List<Shelf> getShelf() {
		return shelf;
	}

	public void setShelf(List<Shelf> shelf) {
		this.shelf = shelf;
	}

	@Override
	public String toString() {
		return "ShopperProduct [id=" + id + ", shopperId=" + shopperId + ", shelf=" + shelf + "]";
	}
	
	
	
	
	
}
