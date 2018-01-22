package com.userfront.domain;

import java.math.BigDecimal;
import java.util.List;

public class PrimaryAccount {

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

	public List<PrimaryTransaction> getPrimaryTransaction() {
		return primaryTransaction;
	}

	public void setPrimaryTransaction(List<PrimaryTransaction> primaryTransaction) {
		this.primaryTransaction = primaryTransaction;
	}

	private List<PrimaryTransaction> primaryTransaction;
}
