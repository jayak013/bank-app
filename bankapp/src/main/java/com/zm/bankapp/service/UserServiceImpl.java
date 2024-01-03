package com.zm.bankapp.service;

import com.zm.bankapp.dao.UserDAO;
import com.zm.bankapp.dao.UserDAOImpl;
import com.zm.bankapp.dto.Account;
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
	public int createAccountAndCust(Customer customer,User user) {
		 int row1 = dao.saveCustomer(customer);
		 int custId = dao.getCustomerIdByAadhaar(customer.getAadhaarNo());
		 customer.setCustId(custId);
		 int row2 =  dao.createAccount(customer);
		 int row3 = dao.saveUserCredentials(user,custId);
		 return row1+row2+row3;
	}

	@Override
	public int getAccountNoByCustId(Integer custId) {
		return dao.getAccountNoByCustomerId(custId);
	}

	@Override
	public User getUserDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCustomerIdByAadhaar(String Aadhaar) {
		return dao.getCustomerIdByAadhaar(Aadhaar);
	}

	@Override
	public int deposit(Account account, Integer amount) {
		return dao.deposit(account, amount);
	}

	@Override
	public int withdraw(Account account, Integer amount) {
		return dao.withdraw(account, amount);
	}



	@Override
	public boolean transferAmount(Account sender, Account receiver, Integer amount) {
		return dao.transferAmount(sender, receiver, amount);
	}


	public Customer getCustomerDetailsByAccountNumber(Integer accountNumber){
		return dao.getCustomerByAccountNumber(accountNumber);
	}


}
