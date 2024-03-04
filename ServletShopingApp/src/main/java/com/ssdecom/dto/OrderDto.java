package com.ssdecom.dto;

public class OrderDto extends CartDto{
	private Integer OrderId;
	private String Date;
	private Integer UserId;
	
	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}
	

	public OrderDto() {
		
	}

	public Integer getOrderId() {
		return OrderId;
	}

	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	
	public OrderDto(Integer id, String productName, String category, Double price, String productImg, Integer quantity,
			Integer orderId, String date, Integer userId) {
		super(id, productName, category, price, productImg, quantity);
		OrderId = orderId;
		Date = date;
		UserId = userId;
	}

	@Override
	public String toString() {
		return "OrderDto [OrderId=" + OrderId + ", Date=" + Date + "]";
	}
	
	
	

}
