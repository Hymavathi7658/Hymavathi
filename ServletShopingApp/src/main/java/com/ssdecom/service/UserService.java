package com.ssdecom.service;

import com.ssdecom.dao.UserDao;
import com.ssdecom.dto.UserDto;

public class UserService {
	public UserDao dao;
	
	
	public UserService() {
		super();
	}

	public UserService(UserDao dao) {
		
		this.dao = dao;
	}


	public void insertUser(UserDto dto) {
		dao.inserUser(dto);
		
	}
	public UserDto isLogin(String Email, String Password) {
		return dao.isLogin(Email, Password);
	}

}
