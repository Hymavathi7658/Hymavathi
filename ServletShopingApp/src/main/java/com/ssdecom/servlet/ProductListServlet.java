package com.ssdecom.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dao.ProductDao;
import com.ssdecom.dto.ProductDto;
import com.ssdecom.service.ProductService;

/**
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
public ProductService service;
	
	public void init() {
		ProductDao dao=new ProductDao();
		service=new ProductService(dao);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<ProductDto> productList=service.getProductList();
		System.out.println("hi..productList.....productList..");
		request.setAttribute("productList", productList);
		request.getRequestDispatcher("landingpage.jsp").forward(request, response);
	}

}
