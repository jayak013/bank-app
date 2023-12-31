package com.zm.bankapp.service;

import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserService<User,Customer> {
	
	boolean validateUserNameAndPassword(User user);
	int createAccountAndCust(Customer customer);
	int getAccountNoByCustId(Customer customer);
}
