package com.zm.bankapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private Integer accountNo;
	private LocalDate createdOn;
	private Double balance;
	private Integer custId;
}
