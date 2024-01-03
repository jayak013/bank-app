package com.zm.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;
import com.zm.bankapp.service.UserService;
import com.zm.bankapp.service.UserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin")
public class AdminController extends HttpServlet{
	private static UserService<User, Customer> service = new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward="";
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
			User user = new User(username,password);
			int rowsInserted = service.createAccountAndCust(customer,user);
			if(rowsInserted!=0) {
				
				response.setContentType("text/html");
				int accNo = service.getAccountNoByCustId(service.getCustomerIdByAadhaar(aadhaar));
				request.setAttribute("customerName", name);
				request.setAttribute("accountNumber", accNo);
				RequestDispatcher rd = request.getRequestDispatcher("create-account.jsp");
				rd.forward(request, response);
				

		        
			}
		}
		if (action.equalsIgnoreCase("deposit")) {
			String accountNo = request.getParameter("accountNumber");
			String amount = request.getParameter("depositAmount");
			Account account = new Account();
			account.setAccountNo(Integer.parseInt(accountNo));
			int rows = service.deposit(account, Integer.parseInt(amount));
			String balance = account.getBalance().toString();
			//request.setAttribute(balance, balance);
			if (rows != 0) {
				HttpSession session = request.getSession();
				request.setAttribute("customerName", "Customer Name: "+
				service.getCustomerDetailsByAccountNumber(Integer.parseInt(accountNo)).getCustName());
				request.setAttribute("creditedAccount", "Account Number: "+accountNo);
				request.setAttribute("creditedAmount", "Credited Amount: "+amount);
				request.setAttribute("closingbal", "Closing Balance: "+balance);
				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
				rd.forward(request, response);
			}

		}

		if (action.equalsIgnoreCase("withdraw")) {
			String accountNo = request.getParameter("accountNumber");
			String amount = request.getParameter("withdrawAmount");
			Account account = new Account();
			account.setAccountNo(Integer.parseInt(accountNo));
			int rows = service.withdraw(account, Integer.parseInt(amount));
			String balance = account.getBalance().toString();
			if (rows != 0) {
				HttpSession session = request.getSession();
				request.setAttribute("customerName", "Customer Name: "+
				service.getCustomerDetailsByAccountNumber(Integer.parseInt(accountNo)).getCustName());
				request.setAttribute("account", "Account Number: "+accountNo);
				request.setAttribute("amountWithdrawn", "Amount Withdrwan: "+amount);
				request.setAttribute("closingbal", "Closing Balance: "+balance);
				RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
				rd.forward(request, response);
				
			}

		}
		
		if (action.equalsIgnoreCase("transfer")) {
			String senderAccountNo = request.getParameter("senderAccountNo");
			String receiverAccountNo = request.getParameter("receiverAccountNo");
			String amount = request.getParameter("transferAmount");
			Account sender = new Account();
			sender.setAccountNo(Integer.parseInt(senderAccountNo));
			System.out.println(sender.getAccountNo()); 
			Account receiver = new Account();
			receiver.setAccountNo(Integer.parseInt(receiverAccountNo));
			System.out.println(receiver.getAccountNo()); 
			boolean transfer = service.transferAmount(sender, receiver, Integer.parseInt(amount));
			if(transfer) {
//				HttpSession session = request.getSession();
//				request.setAttribute("senderDetails", "Sender Name: "+
//				service.getCustomerDetailsByAccountNumber(Integer.parseInt(senderAccountNo)).getCustName()
//				+", Sender Account Number: "+senderAccountNo+"\n Closing Balance: "+"");
//				request.setAttribute("receiverDetails", "Account Number: "+accountNo);
//				request.setAttribute("debitedAmount", "Transferred Amount: "+amount);
//				request.setAttribute("closingbal", "Closing Balance: "+balance);
//				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
//				rd.forward(request, response);
				
				//pending work of queries
				
			}
		}
	}

}
