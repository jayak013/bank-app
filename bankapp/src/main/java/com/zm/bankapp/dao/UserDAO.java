package com.zm.bankapp.dao;

import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserDAO<T extends User,C extends Customer> {
	
	boolean getByUserNameAndPassword(T user);
	int saveCustomer(C customer);
	int createAccount(C customer);
	int saveUserCredentials(User user);
	int getCustomerIdByAadhaar(String aadhaar);
	User getUserDetailsById(Integer id);
	int getAccountNoByCustomerId(Integer id);
}
