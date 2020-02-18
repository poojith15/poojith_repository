package com.lpu.MavenDemo.dao;

import com.lpu.MavenDemo.entity.AccountManagement;
import com.lpu.MavenDemo.exceptions.AccountIdException;

/**
 * 
 * @author pooji
 *This is an interface which holds the implementations of DAO layer.
 */

public interface TransactionDao {
	public AccountManagement getAccount(String accountid)throws AccountIdException;
	
	public void updateAccount(String accid,double amount);

}
