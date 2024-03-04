package com.ssdecom.dto;

public class ProductDto {
	private Integer Id;
	private String ProductName;
	private String Category;
	private Double Price;
	private String ProductImg;
	
	
	public ProductDto(Integer id, String productName, String category, Double price, String productImg) {
		super();
		Id = id;
		ProductName = productName;
		Category = category;
		Price = price;
		ProductImg = productImg;
	}
	
	public ProductDto(String productName, String category, Double price, String productImg) {
		super();
		ProductName = productName;
		Category = category;
		Price = price;
		ProductImg = productImg;
	}

	public ProductDto() {
		
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getProductImg() {
		return ProductImg;
	}
	public void setProductImg(String productImg) {
		ProductImg = productImg;
	}
	@Override
	public String toString() {
		return "ProductDto [Id=" + Id + ", ProductName=" + ProductName + ", Category=" + Category + ", Price=" + Price
				+ ", ProductImg=" + ProductImg + "]";
	}
	
	
	

}
