package com.ssdecom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dto.CartDto;
import com.ssdecom.dto.OrderDto;
import com.ssdecom.dto.UserDto;
import com.ssdecom.service.OrderService;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 UserDto userDto=(UserDto) request.getSession().getAttribute("user");
		
		System.out.println("this is orderservlet");
		
		String action=request.getParameter("action");
		Integer productId=Integer.valueOf( request.getParameter("id"));
		
		
		OrderService os=new OrderService();
		
		if(action!=null && action.equalsIgnoreCase("landing")) {
			os.placeOrders(productId, 1, userDto.getUserId());
			request.getRequestDispatcher("productlist").forward(request, response);
			
			return;
		}else {
			Integer Quantity=Integer.valueOf(request.getParameter("quantity"));

			os.placeOrders(productId, Quantity, userDto.getUserId());
			
			List<CartDto> oldCartList=(List<CartDto>) request.getSession().getAttribute("oldcartlist");
			
			int index=0;
			for(CartDto cdto:oldCartList) {
				if(cdto.getId()==productId) {
					index=oldCartList.indexOf(cdto);
				}
			}
			
			oldCartList.remove(index);
			request.getSession().setAttribute("oldcartlist", oldCartList);
			request.getRequestDispatcher("cartlistservlet").forward(request, response);
			
			return;
		}
		
		
		
	}

}
