package com.zm.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;
import com.zm.bankapp.service.UserService;
import com.zm.bankapp.service.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create-account")
public class AdminController extends HttpServlet{
	private static UserService<User, Customer> service = new UserServiceImpl();
	private static String action = null;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		if(action.equalsIgnoreCase("create")) {
			String name = request.getParameter("name");
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			String gender = request.getParameter("gender");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			String aadhaar = request.getParameter("aadhaar");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			
			Customer customer = new Customer(name,dob, gender, mobile, 
										email, aadhaar, address);
			int rowsInserted = service.createAccountAndCust(customer);
			if(rowsInserted!=0) {
				response.setContentType("text/html");
				out.print("<h2>Account is created for Mr./Mrs. "+ name +"</h2>");
				out.print("<h2>Account Number is "+ service.getAccountNoByCustId(customer) +"</h2>");
			}
		}
	}
}
