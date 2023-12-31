package com.zm.bankapp.service;

import com.zm.bankapp.dao.UserDAO;
import com.zm.bankapp.dao.UserDAOImpl;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public class UserServiceImpl implements UserService<User,Customer>{
	
	public static UserDAO dao = null;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}

	@Override
	public boolean validateUserNameAndPassword(User user) {
		return dao.getByUserNameAndPassword(user);
	}

	@Override
	public int createAccountAndCust(Customer customer) {
		 int row1 = dao.saveCustomer(customer);
		 int custId = dao.getCustomerIdByName(customer.getCustName());
		 customer.setCustId(custId);
		 int row2 =  dao.createAccount(customer);
		 return row1+row2;
	}

	@Override
	public int getAccountNoByCustId(Customer customer) {
		return dao.getCustomerIdByName(customer.getCustName());
	}

}
