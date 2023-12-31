package com.zm.bankapp.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer extends User {
	private Integer custId;
	private String custName;
	private LocalDate dob;
	private String gender;
	private String mobile;
	private String email;
	private String aadhaarNo;
	private String address;
	private int accountNo;

	public Customer(String custName, LocalDate dob, String gender, String mobile, String email, String aadhaarNo,
			String address) {
		this.custName = custName;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.aadhaarNo = aadhaarNo;
		this.address = address;
	}

	public Customer(Integer custId,String custName, LocalDate dob, 
			String gender, String mobile, String email, String aadhaarNo,
			String address) {
		this(custName,dob,gender,mobile,email,aadhaarNo,address);
		this.custId = custId;
	}
}
