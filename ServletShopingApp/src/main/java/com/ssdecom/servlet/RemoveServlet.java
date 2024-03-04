package com.ssdecom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dto.CartDto;

/**
 * Servlet implementation class RemoveServlet
 */
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<CartDto> oldcartlist=  (List<CartDto>) request.getSession().getAttribute("oldcartlist");
		Integer id=Integer.valueOf(request.getParameter("id"));
		int index=0;
		for(CartDto dto:oldcartlist) {
			if(dto.getId()==id) {
				index=oldcartlist.indexOf(dto);
			}
			
		}
		oldcartlist.remove(index);
		request.getSession().setAttribute("oldcartlist", oldcartlist);
		request.getRequestDispatcher("cartlistservlet").forward(request, response);
	}

}
