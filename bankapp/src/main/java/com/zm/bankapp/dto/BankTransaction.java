package com.zm.bankapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankTransaction {
	private Integer txId;
	private LocalDate txDate;
	private String txType;
	private Double amount;
	private Integer accountNo;
	private Integer adminId;
	
	

}
