package com.zm.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
	private String userName;
	private String password;
	private String userType;
	private Integer custId;
	private Integer adminId;
	
	public User(String username,String password) {
		this.userName = username;
		this.password = password;
	}
	
}
