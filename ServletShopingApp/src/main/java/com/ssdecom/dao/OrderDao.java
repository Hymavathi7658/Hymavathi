package com.ssdecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ssdecom.dto.OrderDto;
import com.ssdecom.util.DbConnection;

public class OrderDao {
	
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;
	
	public void placeOrder(Integer pid, Integer quantity, Integer UserId) {
		
		con=DbConnection.getDbConnection();
		OrderDto odto=new OrderDto();
		String qurry="select * from producttable where Id=?";
		String Insertqurry=" INSERT INTO ordertable (Id, ProductName, Quantity, Date,ProductImg,UserId) VALUES(?,?,?,?,?,?)";
		try {
			pre=con.prepareStatement(qurry);
			pre.setInt(1, pid);
			rs=pre.executeQuery();
			
			while(rs.next()) {
				pre=con.prepareStatement(Insertqurry);
				
				pre.setInt(1, pid);
				pre.setString(2, rs.getString(2));
				pre.setInt(3, quantity);
				
				pre.setString(4, LocalDateTime.now().toString());
				pre.setString(5,rs.getString(5));
				pre.setInt(6,UserId );
				
				int noOfRec=pre.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<OrderDto> getOrderedList(Integer UserId){
		con=DbConnection.getDbConnection();
		List<OrderDto> orderList=new ArrayList<OrderDto>();
		
		try {
			pre=con.prepareStatement("select * from ordertable where UserId=? ");
			pre.setInt(1, UserId);
			rs=pre.executeQuery();
			while(rs.next()) {
				OrderDto odto=new OrderDto();
				odto.setOrderId(rs.getInt(1));
				odto.setId(rs.getInt(2));
				odto.setProductName(rs.getString(3));
				odto.setQuantity(rs.getInt(4));
				odto.setDate(rs.getString(5));
				odto.setProductImg(rs.getString(6));
				odto.setUserId(rs.getInt(7));
				
				orderList.add(odto);
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return orderList;
		
	}

}
