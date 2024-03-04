package com.ssdecom.dto;

public class CartDto extends ProductDto{
	private Integer Quantity;

	public CartDto(Integer id, String productName, String category, Double price, String productImg, Integer quantity) {
		super(id, productName, category, price, productImg);
		Quantity = quantity;
	}
	
	public CartDto() {
		
	}
	@Override
	public String toString() {
		return "CartDto [Quantity=" + Quantity + "]";
	}


	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	

}
