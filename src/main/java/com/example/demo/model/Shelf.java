package com.example.demo.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Shelf {
	
	
//	@OneToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "id",
//	                     insertable = false, updatable = false)
	private String productId;
	private double relevancyScore;
	
	public Shelf() {
		
	}
	
	public Shelf(String productId, double relevancyScore) {
		
		this.productId = productId;
		this.relevancyScore = relevancyScore;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public double getRelevancyScore() {
		return relevancyScore;
	}

	public void setRelevancyScore(double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}

	@Override
	public String toString() {
		return "Shelf [productId=" + productId + ", relevancyScore=" + relevancyScore + "]";
	}
	
	
	
	

}
