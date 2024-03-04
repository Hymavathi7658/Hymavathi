package com.ssdecom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssdecom.dto.CartDto;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hi..........................");
		
		HttpSession session=request.getSession();
		List<CartDto> oldcartlist=(List<CartDto>) session.getAttribute("oldcartlist");
		 List<CartDto> newCartlist=new ArrayList<CartDto>();
		
		String id= request.getParameter("id");
		Integer productId=Integer.valueOf(id);
		CartDto cdto=new CartDto();
		if(oldcartlist!=null && !oldcartlist.isEmpty() && oldcartlist.size()>0) {
			newCartlist=oldcartlist;
			for(CartDto cart:newCartlist) {
			
			if(cart.getId()==productId) {
				request.getRequestDispatcher("cart.jsp").forward(request, response);
				return;
			}
		}
			cdto.setId(productId);
		cdto.setQuantity(1);
		oldcartlist.add(cdto);
		
		session.setAttribute("oldcartlist", newCartlist);
		request.getRequestDispatcher("productlist").forward(request, response);
		}else {
		cdto.setId(productId);
		cdto.setQuantity(1);
		newCartlist.add(cdto);
		
		session.setAttribute("oldcartlist", newCartlist);
		request.getRequestDispatcher("productlist").forward(request, response);
		
		}
		
		}
	

}
