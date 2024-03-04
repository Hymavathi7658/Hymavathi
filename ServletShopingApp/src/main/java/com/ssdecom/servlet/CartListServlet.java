package com.ssdecom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dao.ProductDao;
import com.ssdecom.dto.CartDto;
import com.ssdecom.service.ProductService;

/**
 * Servlet implementation class CartListServlet
 */
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
public ProductService product;
	
	public void init() {
		ProductDao dao=new ProductDao();
		product=new ProductService(dao);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CartDto> cartList= (List<CartDto>) request.getSession().getAttribute("oldcartlist");
		
		if(cartList!=null && !cartList.isEmpty() && cartList.size()>0) {
		cartList=product.getProductsfromCart(cartList);
		double totalPrice=0.0;
		
		for(CartDto dto:cartList) {
			totalPrice=totalPrice+dto.getQuantity()*dto.getPrice();
			
		}
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("cartList.jsp").forward(request, response);
		}else {
			response.sendRedirect("productlist");
		}
		
		
	}

}
