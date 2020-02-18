package com.cg.BankTransaction.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AccountManagement {
     private String accountId;
     private Customer accountHolder=new Customer();
     private String accountBranchId;
     private String accountType;
     private String accountStatus;
     private double accountBalance;
     private double accountInterest;
     private LocalDate lastUpdated;
     private List<AccTransaction> trxns=new ArrayList();
     /**
      * 
      */
	public AccountManagement() {
		
	}
	
	public AccountManagement(String accountId, Customer accountHolder, String accountBranchId, String accountType,
			String accountStatus, double accountBalance, double accountInterest, LocalDate lastUpdated,
			List<AccTransaction> trxns) {
		super();
		this.accountId = accountId;
		this.accountHolder = accountHolder;
		this.accountBranchId = accountBranchId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.accountInterest = accountInterest;
		this.lastUpdated = lastUpdated;
		this.trxns = trxns;
	}

	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public String getAccountBranchId() {
		return accountBranchId;
	}
	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getAccountInterest() {
		return accountInterest;
	}
	public void setAccountInterest(double accountInterest) {
		this.accountInterest = accountInterest;
	}
	public LocalDate getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	public List<AccTransaction> getTrxns() {
		return trxns;
	}
	public void setTrxns(List<AccTransaction> trxns) {
		this.trxns = trxns;
	}
	@Override
	public String toString() {
		
		return "Account Id"+accountId+accountHolder+"Account Type"+accountType+"Account Status"+accountStatus
				+"Account Interest"+accountInterest+"lastUpdated"+lastUpdated;
	}
     
     
}
