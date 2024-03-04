package com.ssdecom.service;

import java.util.List;

import com.ssdecom.dao.ProductDao;
import com.ssdecom.dto.CartDto;
import com.ssdecom.dto.ProductDto;

public class ProductService {
	
	public ProductDao dao;

	public ProductService(ProductDao dao) {
		super();
		this.dao = dao;
	}
	public ProductService() {
		
	}
	
	public void addProducts(ProductDto dto) {
		dao.addProducts(dto);
		
	}
	public List<ProductDto> getProductList(){
		
		return  dao.getProductList();
		
	}
	
	public List<CartDto> getProductsfromCart(List<CartDto> cartList){
		
		return dao.getProductsFromCart(cartList);
	}
	

}
