package com.zm.bankapp.dao;

import com.zm.bankapp.dto.Customer;

public interface UserDAO<User,Customer> {
	boolean getByUserNameAndPassword(User user);
	int saveCustomer(Customer customer);
	int createAccount(Customer customer);
	int saveUserCredentials(User user);
	int getCustomerIdByName(String name);
}
