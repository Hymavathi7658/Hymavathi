package com.ssdecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssdecom.dto.CartDto;
import com.ssdecom.dto.OrderDto;
import com.ssdecom.dto.ProductDto;
import com.ssdecom.util.DbConnection;

public class ProductDao {
	
	
	private Connection con=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	
	public void addProducts(ProductDto dto) {
		String str=" INSERT INTO producttable(ProductName, Category, Price, ProductImg) VALUES (?,?,?,?)";
		con=DbConnection.getDbConnection();
		try {
			pre=con.prepareStatement(str);
			pre.setString(1, dto.getProductName());
			pre.setString(2, dto.getCategory());
			pre.setDouble(3, dto.getPrice());
			pre.setString(4, dto.getProductImg());
			
			pre.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<ProductDto> getProductList(){
		con=DbConnection.getDbConnection();
		List<ProductDto> productList=new ArrayList<ProductDto>();
		String str="select * from producttable";
		try {
			Statement st =con.createStatement();
			rs=st.executeQuery(str);
			while(rs.next()) {
				ProductDto dto=new ProductDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
				
				productList.add(dto);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}
	
	public List<CartDto> getProductsFromCart(List<CartDto> cartList){
		
		con=DbConnection.getDbConnection();
		List<CartDto> list=new ArrayList<CartDto>();
		
		
		try {
			
			
			for(CartDto newdto:cartList) {
				pre=con.prepareStatement("select * from producttable where Id=?");
				pre.setInt(1, newdto.getId());
				rs=pre.executeQuery();
				CartDto dto=new CartDto();
				while(rs.next()) {
					
					dto.setId(rs.getInt(1));
					dto.setProductName(rs.getString(2));
					dto.setCategory(rs.getString(3));
					dto.setPrice(rs.getDouble(4));
					dto.setProductImg(rs.getString(5));
					dto.setQuantity(newdto.getQuantity());
					
					list.add(dto);
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	

}
