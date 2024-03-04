package com.ssdecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssdecom.dto.UserDto;
import com.ssdecom.util.DbConnection;

public class UserDao {
	
	private Connection con=null;
	private PreparedStatement pre=null;
	private ResultSet rs=null;
	
	String InsertUser="INSERT INTO ssdecomtable(Name,Email,PhoneNo,AdharNo,Password) VALUES(?,?,?,?,?)";
	
	public void inserUser(UserDto dto) {
		con=DbConnection.getDbConnection();
		try {
			pre=con.prepareStatement(InsertUser);
			pre.setString(1, dto.getName());
			pre.setString(2, dto.getEmail());
			pre.setString(3, dto.getPhoneNo());
			pre.setString(4, dto.getAdharNo());
			pre.setString(5, dto.getPassword());
			pre.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//	public boolean isLogin(String Email, String Password) {
//		con=DbConnection.getDbConnection();
//		boolean islogin=false;
//		String str="select * from ssdecom.ssdecomtable where Email=? and Password=?";
//		try {
//			pre=con.prepareStatement(str);
//			pre.setString(1, Email);
//			pre.setString(2, Password);
//			rs=pre.executeQuery();
//			islogin=rs.next();
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return islogin;
//		
//	}
	
	public UserDto isLogin(String Email, String Password) {
		con=DbConnection.getDbConnection();
	
		String str="select * from ssdecom.ssdecomtable where Email=? and Password=?";
		UserDto dto=new UserDto();
		try {
			pre=con.prepareStatement(str);
			pre.setString(1, Email);
			pre.setString(2, Password);
			rs=pre.executeQuery();
			while(rs.next()) {
				
			dto.setUserId(rs.getInt(1));
			dto.setName(rs.getString(2));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
		
	}

}
