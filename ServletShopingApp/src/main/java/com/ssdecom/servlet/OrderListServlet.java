package com.ssdecom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dto.OrderDto;
import com.ssdecom.dto.UserDto;
import com.ssdecom.service.OrderService;

/**
 * Servlet implementation class OrderListServlet
 */
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dgrfxhngjnghm");
		UserDto userDto=(UserDto) request.getSession().getAttribute("user");
		
		OrderService os=new OrderService();
		List<OrderDto> orderList= os.getOrderedList(userDto.getUserId());
		
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("orderlist.jsp").forward(request, response);
	}

}
