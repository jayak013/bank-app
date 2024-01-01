package com.zm.bankapp.service;

import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserService<T extends User,C extends Customer> {
	
	boolean validateUserNameAndPassword(T user);
	int createAccountAndCust(C customer);
	int getAccountNoByCustId(Integer id);
	User getUserDetailsById(Integer id);
	int getCustomerIdByAadhaar(String Aadhaar);
}
