package com.ssdecom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dto.CartDto;

/**
 * Servlet implementation class QuantityServelet
 */
public class QuantityServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuantityServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<CartDto> oldCartList= (List<CartDto>) request.getSession().getAttribute("oldcartlist");
		
        String action=request.getParameter("action");
        Integer id=Integer.valueOf( request.getParameter("id"));
		
		for(CartDto dto :oldCartList) {
			if(dto.getId()==id) {
				
				if(action.equalsIgnoreCase("inc")) {
				
				dto.setQuantity(dto.getQuantity()+1);
				}else {
					dto.setQuantity(dto.getQuantity()-1);
				}
			}
		}
		request.getRequestDispatcher("cartlistservlet").forward(request, response);
	}

}
