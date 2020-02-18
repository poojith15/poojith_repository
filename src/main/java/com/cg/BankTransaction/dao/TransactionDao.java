package com.cg.BankTransaction.dao;

import com.cg.BankTransaction.entity.AccountManagement;
import com.cg.BankTransaction.exceptions.AccountIdException;

public interface TransactionDao {
	public AccountManagement getAccount(String accountid)throws AccountIdException;
	
	public void updateAccount(String accid,double amount);

}
