package com.ssdecom.service;

import java.util.List;

import com.ssdecom.dao.OrderDao;
import com.ssdecom.dto.OrderDto;

public class OrderService {
	OrderDao dao=new OrderDao();
	
	public void placeOrders(Integer pid,Integer quantity,Integer UserId) {
		dao.placeOrder(pid, quantity, UserId);
	}
	public List<OrderDto> getOrderedList(Integer UserId){
		return dao.getOrderedList(UserId);
	}

}
