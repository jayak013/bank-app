package com.zm.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("username").equalsIgnoreCase("jaya krishna")){
			  RequestDispatcher rd = request.getRequestDispatcher("admin-dashboard.jsp");
				rd.forward(request, response);
		}else{
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<body>");
			out.println("<h2 style=\"position:absolute;margin-top:500px\">Login credentials gone wrong...</h2>");
			out.println("</body>");
			out.println("</html>");
			 RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			
		}

		
	}
}
