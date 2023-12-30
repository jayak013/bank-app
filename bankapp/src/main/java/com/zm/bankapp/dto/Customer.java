package com.zm.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Customer {
	private Integer custId;
	private String custName;
	private String gender;
	private String mobile;
	private String email;
	private String aadhaarNo;
	private String address;
}
