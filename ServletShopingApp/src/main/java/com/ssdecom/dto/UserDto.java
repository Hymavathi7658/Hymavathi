package com.ssdecom.dto;

public class UserDto {
	private Integer UserId;
	private String Name;
	private String Email;
	private String PhoneNo;
	private String AdharNo;
	private String Password;
	
	public UserDto() {
		super();
	}

	public UserDto(Integer userId, String name, String email, String phoneNo, String adharNo, String password) {
		super();
		UserId = userId;
		Name = name;
		Email = email;
		PhoneNo = phoneNo;
		AdharNo = adharNo;
		Password = password;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNo() {
		return PhoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}

	public String getAdharNo() {
		return AdharNo;
	}

	public void setAdharNo(String adharNo) {
		AdharNo = adharNo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "UserDto [UserId=" + UserId + ", Name=" + Name + ", Email=" + Email + ", PhoneNo=" + PhoneNo
				+ ", AdharNo=" + AdharNo + ", Password=" + Password + "]";
	}
	
	
	
	
	

}
