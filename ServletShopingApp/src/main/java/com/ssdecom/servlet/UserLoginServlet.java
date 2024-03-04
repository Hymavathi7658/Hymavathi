package com.ssdecom.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdecom.dao.UserDao;
import com.ssdecom.dto.UserDto;
import com.ssdecom.service.UserService;
import com.ssdecom.util.Validations;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService service;
	
	public void init() {
		
		UserDao dao=new UserDao();
		service=new UserService(dao);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action=request.getServletPath();
		try {
		switch(action) {
		case "/login":
			
				showLoginForm(request, response);
			
			break;
		case "/signup":
			showSignupForm(request, response);
			break;
		case "/userlogin":
			userLogin(request, response);
			
			break;
		case "/usersignup":
			insert(request, response);
			break;
			default:
				welcomPage(request, response);
				break;
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	private void showLoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(request.getServletPath());
		response.sendRedirect("login.jsp");
		
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
	   String email=request.getParameter("Email");
	   String password=request.getParameter("Password");
	UserDto user = service.isLogin(email, password);
	   if(user!=null) {
		   request.getSession().setAttribute("user", user);
		   request.getRequestDispatcher("./productlist").forward(request, response);
		   
	   }else {
		   response.sendRedirect("login.jsp");
	   }
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDto dto=new UserDto() ;
		String errmsg="please enter valid  ";
		
		String name=request.getParameter("Name");
		String email=request.getParameter("Email");
		String phoneNo=request.getParameter("PhoneNo");
		String adharNo=request.getParameter("AdharNo");
		String password=request.getParameter("Password");
		boolean isValidation=false;
		
		if(name!=null && !name.isEmpty() && !name.isBlank() && name.length()>2 && name.length()<45 && Validations.validateLetters(name)){
		   dto.setName(name);
		}else {
			errmsg="please enter valid name" ;
			   isValidation=false;
			   request.setAttribute("isValidation", isValidation);
				
				request.setAttribute("errmsg", errmsg);
					request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		if(email!=null && !email.isEmpty() && !email.isBlank() && email.length()>2 && email.length()<45 && Validations.validateEmail(email)) {
			dto.setEmail(email);
		}else {
			errmsg=errmsg+" email";
			isValidation=false;
			request.setAttribute("isValidation", isValidation);
			request.setAttribute("errmsg", errmsg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			
		}
		if(phoneNo!=null && !phoneNo.isEmpty() && !phoneNo.isBlank() && Validations.validatePhoneNo(phoneNo)) {
			dto.setPhoneNo(phoneNo);
		}else {
			errmsg=errmsg+" PhoneNo";
			isValidation=false;
			request.setAttribute("isValidation", isValidation);
			request.setAttribute("errmsg", errmsg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			
		}
		if(Validations.validateAdharNo(adharNo)) {
			dto.setAdharNo(adharNo);
			
		}else {
			errmsg=errmsg+" AdharNo";
			isValidation=false;
			request.setAttribute("isValidation", isValidation);
			request.setAttribute("errmsg", errmsg);
			request.getRequestDispatcher("signup.jsp").forward(request, response);
			
		}
		   if(!isValidation){
			   System.out.println("gdtyqdjlhgdfdd");
			   dto.setPassword(password);
			   service.insertUser(dto);
			   
			request.getRequestDispatcher("login.jsp").forward(request, response);
		   }
	
		}
		
	private void welcomPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void showSignupForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("signup.jsp");
	}

	
	

}
