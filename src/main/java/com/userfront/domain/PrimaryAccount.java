package com.userfront.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PrimaryAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int accountNumber;
	private BigDecimal accountBalance; // eliminates problem of calculation issues

	@OneToMany(
		mappedBy = "primaryAccount", 
		cascade = CascadeType.ALL, // updates will be put to all values 
		fetch = FetchType.LAZY // lazy loading
	)
	@JsonIgnore // without this transaction there will be an infinite loop because PrimaryTransaction has also a reference to PrimaryAccount
	private List<PrimaryTransaction> primaryTransactionList; 

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

	public List<PrimaryTransaction> getPrimaryTransactionList() {
		return primaryTransactionList;
	}

	public void setPrimaryTransactions(List<PrimaryTransaction> primaryTransaction) {
		this.primaryTransactionList = primaryTransaction;
	}

}
