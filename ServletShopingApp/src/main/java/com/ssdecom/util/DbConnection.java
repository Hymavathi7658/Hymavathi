package com.ssdecom.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.ssdecom.dao.OrderDao;
import com.ssdecom.dao.UserDao;
import com.ssdecom.dto.UserDto;

public class DbConnection {
	public static void main(String[] args) {
		UserDao dao=new UserDao();
		UserDto dto =new UserDto();
//		dto.setName("Hyma");
//		dto.setEmail("hyma@gmail.com");
//		dto.setPhoneNo("4556478786");
//		dto.setAdharNo("138276783537");
//		dao.inserUser(dto);
		
//		OrderDao dao=new OrderDao();
//		dao.placeOrder(2, 1);
		System.out.println( dao.isLogin("hyma@gmail.com", "hy46"));
		
	}
	
	public static Connection getDbConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdecom","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	
	}

}
