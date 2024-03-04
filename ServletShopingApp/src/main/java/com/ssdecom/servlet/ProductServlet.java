package com.ssdecom.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dao.ProductDao;
import com.ssdecom.dto.ProductDto;
import com.ssdecom.service.ProductService;
import com.ssdecom.util.Validations;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public ProductService product;
	
	public void init() {
		ProductDao dao=new ProductDao();
		product=new ProductService(dao);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDto dto=new ProductDto();
		String productName=request.getParameter("ProductName");
		String category=request.getParameter("Category");
	    Double  price =Double.parseDouble(request.getParameter("Price"));
		String productImg=request.getParameter("ProductImg") ;
		String errormsg="please enter valid ";
		 boolean isValidation=true;
		
		if(productName!=null && !productName.isEmpty() && !productName.isBlank() && Validations.validateProductName(productName)) {
			dto.setProductName(productName);
		}else {
			errormsg=errormsg+" productname";
			isValidation=true;
			request.setAttribute("isValidation", isValidation);
			request.setAttribute("errormsg", errormsg);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		if(category!=null && !category.isEmpty() && !category.isBlank() && Validations.validateLetters(category)) {
			dto.setCategory(category);
		}else {
			errormsg=errormsg+" category";
			isValidation=true;
			request.setAttribute("isValidation", isValidation);
			request.setAttribute("errormsg", errormsg);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		if(productImg!=null && !productImg.isEmpty() && !productImg.isBlank() && Validations.validateImage(productImg)) {
			dto.setProductImg(productImg);
			
		}else {
			errormsg=errormsg+" product image";
			isValidation=true;
			request.setAttribute("isValidation", isValidation);
			request.setAttribute("errormsg", errormsg);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		
		
		if(isValidation) {
		dto.setPrice(price);
		
		product.addProducts(dto);
		
		response.sendRedirect("./productlist");
		}
	}

}
