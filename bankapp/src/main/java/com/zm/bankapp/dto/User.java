package com.zm.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class User {
	private Integer userId;
	private String password;
	private String userType;
	private Integer custId;
	private Integer adminId;
}
