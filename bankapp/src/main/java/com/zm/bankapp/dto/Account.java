package com.zm.bankapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Account {
	private Integer accountNo;
	private LocalDate createdOn;
	private Double balance;
	private Integer custId;
}
