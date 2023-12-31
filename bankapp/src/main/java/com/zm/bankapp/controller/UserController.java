package com.zm.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;
import com.zm.bankapp.service.UserService;
import com.zm.bankapp.service.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserController extends HttpServlet{
	public static UserService<User,Customer> service = null;
	static String loginUser = null;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			if(loginUser==null)loginUser = (String)request.getSession().getAttribute("login");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User(username,password);
			if(service.validateUserNameAndPassword(user)){
				  if(loginUser.equalsIgnoreCase("admin")) {
					  RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.jsp");
					  rd.forward(request, response);
				  }else {
					  RequestDispatcher rd = request.getRequestDispatcher("customer-dashboard.jsp");
					  rd.forward(request, response);
				  }
			}else{
				request.setAttribute("error", "Invalid username or password!");
				if(loginUser.equalsIgnoreCase("admin")) {
					 RequestDispatcher rd = request.getRequestDispatcher("login.jsp?login=admin");
					 rd.forward(request, response);
				  }else {
					  RequestDispatcher rd = request.getRequestDispatcher("login.jsp?login=customer");
					  rd.forward(request, response);
				  }
				
				
			}
		}

	@Override
	public void init(ServletConfig config) throws ServletException {
		service = new UserServiceImpl();
	}
}
