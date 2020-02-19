package com.lpu.MavenDemo.service;

import java.util.List;

import com.lpu.MavenDemo.entity.AccTransaction;
import com.lpu.MavenDemo.entity.Cheque;
import com.lpu.MavenDemo.exceptions.AccountIdException;
import com.lpu.MavenDemo.exceptions.AccountIdFormateException;
import com.lpu.MavenDemo.exceptions.AmountException;
import com.lpu.MavenDemo.exceptions.TransactionTypeException;

/**
 * 
 * @author poojith This interface class holds the implements of service class.
 */
public interface TransactionService {
	public boolean doTransaction(String accid, String txType, double amt)
			throws AccountIdFormateException, AmountException, TransactionTypeException, AccountIdException;

	public boolean doTransaction(Cheque cheque, String txType, double amt)
			throws AccountIdFormateException, TransactionTypeException, AmountException, AccountIdException;

	public int viewTransactions(String accid) throws AccountIdFormateException, AccountIdException;

}
