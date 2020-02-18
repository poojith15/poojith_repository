package com.cg.BankTransaction.dao;

import com.cg.BankTransaction.entity.AccountManagement;
import com.cg.BankTransaction.exceptions.AccountIdException;

/**
 * 
 * @author pooji
 *This is an interface which holds the implementations of DAO layer.
 */

public interface TransactionDao {
	public AccountManagement getAccount(String accountid)throws AccountIdException;
	
	public void updateAccount(String accid,double amount);

}
