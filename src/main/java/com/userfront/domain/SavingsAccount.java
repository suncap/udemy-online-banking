package com.userfront.domain;

import java.math.BigDecimal;
import java.util.List;

public class SavingsAccount {

	private Long id;
	private int accountNumber;
	private BigDecimal accountBalance; // eliminates problem of calculation issues

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<SavingsTransaction> getPrimaryTransaction() {
		return savingsTransaction;
	}

	public void setPrimaryTransaction(List<SavingsTransaction> savingsTransaction) {
		this.savingsTransaction = savingsTransaction;
	}

	private List<SavingsTransaction> savingsTransaction;
}