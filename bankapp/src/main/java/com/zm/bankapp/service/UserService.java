package com.zm.bankapp.service;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserService<T extends User,C extends Customer> {
	
	boolean validateUserNameAndPassword(T user);
	int createAccountAndCust(C customer,T user);
	int getAccountNoByCustId(Integer id);
	User getUserDetailsById(Integer id);
	int getCustomerIdByAadhaar(String Aadhaar);
	int deposit(Account account, Integer amount);
	int withdraw(Account account, Integer amount);
	boolean transferAmount(Account sender, Account receiver, Integer amount);
	C getCustomerDetailsByAccountNumber(Integer accountNumber);
}
