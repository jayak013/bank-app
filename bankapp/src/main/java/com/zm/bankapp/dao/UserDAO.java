package com.zm.bankapp.dao;

import com.zm.bankapp.dto.Account;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public interface UserDAO<T extends User,C extends Customer> {
	
	boolean getByUserNameAndPassword(T user);
	int saveCustomer(C customer);
	int createAccount(C customer);
	int saveUserCredentials(User user,Integer custId);
	int getCustomerIdByAadhaar(String aadhaar);
	int getAccountNoByCustomerId(Integer id);
	int deposit(Account account, Integer amount);
	int withdraw(Account account, Integer amount);
	int saveTransaction(Account account, Integer amount, String txType);
	boolean transferAmount(Account sender, Account receiver, Integer amount);
	C getCustomerByAccountNumber(Integer accountNumber);
}
