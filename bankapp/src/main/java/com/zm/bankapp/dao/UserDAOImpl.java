package com.zm.bankapp.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.zm.bankapp.config.ConnectionFactory;
import com.zm.bankapp.dto.Customer;
import com.zm.bankapp.dto.User;

public class UserDAOImpl implements UserDAO<User,Customer>{
	
	public static Connection con=null;
	public static PreparedStatement pst = null;
	
	public UserDAOImpl() {
		try {
			con = ConnectionFactory.establishConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean getByUserNameAndPassword(User user) {
		String query = "select * from bank_app.user where user_id = ? and password = ?";
		boolean validate = false;
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, user.getUserName().toUpperCase());
			pst.setString(2, user.getPassword().toUpperCase());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) validate=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validate;
	}
	@Override
	public int saveCustomer(Customer customer) {
		int rows = 0;
		String query = "INSERT INTO bank_app.customer("
				+ "cust_name, gender, mobile, email, aadhaar, address, dob)"
				+ "	VALUES ( ?, ?, ?, ?, ?, ?, ?);";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, customer.getCustName().toUpperCase());
			pst.setString(2, customer.getGender().toUpperCase());
			pst.setString(3, customer.getMobile());
			pst.setString(4, customer.getEmail().toUpperCase());
			pst.setString(5, customer.getAadhaarNo());
			pst.setString(6, customer.getAddress().toUpperCase());
			pst.setDate(7, Date.valueOf(customer.getDob()));
			
			rows = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	@Override
	public int saveUserCredentials(User user) {
		int rows = 0;
		String query = "INSERT INTO user("
				+ "user_id, password, user_type, cust_id, admin_id)"
				+ "	VALUES ( ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getUserName().toUpperCase());
			pst.setString(2, user.getPassword().toUpperCase());
			pst.setString(3, "CUSTOMER");
			pst.setInt(4, user.getCustId());
			rows = pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	@Override
	public int getCustomerIdByAadhaar(String aadhaar) {
		int id = 0;
		String query = "select cust_id from customer where aadhaar=?";
		try {
			pst = con.prepareStatement(query);
			pst.setString(1, aadhaar);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) id=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	
	
	public int createAccount(Customer customer) {
		int rows = 0;
		String query = "INSERT INTO account("
				+ " created_on,balance, cust_id)"
				+ "	VALUES ( ?, ?, ?)";
		try {
			pst = con.prepareStatement(query);
			pst.setDate(1, Date.valueOf(LocalDate.now()));
			pst.setInt(2, 0);
			pst.setInt(3, customer.getCustId());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rows;
	}
	@Override
	public User getUserDetailsById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getAccountNoByCustomerId(Integer id) {
		int accountNo = 0;
		String query = "select accountNo from account where cust_id = ?";
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) accountNo=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountNo;
	}

}
