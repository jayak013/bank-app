package com.zm.bankapp.dao;

import com.zm.bankapp.dto.Customer;

public interface UserDAO<User,Customer> {
	
	boolean getByUserNameAndPassword(User user);
	int saveCustomer(Customer customer);
	int createAccount(Customer customer);
	int saveUserCredentials(User user);
	int getCustomerIdByAadhaar(String aadhaar);
	User getUserDetailsById(Integer id);
	int getAccountNoByCustomerId(Integer id);
}
