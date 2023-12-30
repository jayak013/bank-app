package com.zm.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Admin {
	private Integer adminId;
	private String adminName;
	private String email;
}
