package com.cg.BankTransaction.service;

import java.util.List;

import com.cg.BankTransaction.entity.AccTransaction;
import com.cg.BankTransaction.entity.Cheque;
import com.cg.BankTransaction.exceptions.AccountIdException;
import com.cg.BankTransaction.exceptions.AccountIdFormateException;
import com.cg.BankTransaction.exceptions.AmountException;
import com.cg.BankTransaction.exceptions.TransactionTypeException;

/**
 * 
 * @author poojith
 *This interface class holds the implements of service class.
 */
public interface TransactionService {
       public boolean doTransaction(String accid,String txType,double amt)
    		   throws AccountIdFormateException,AmountException,TransactionTypeException,AccountIdException;
       public boolean doTransaction(Cheque cheque,String txType,double amt)
    		   throws AccountIdFormateException, TransactionTypeException, AmountException, AccountIdException;
       public int viewTransactions(String accid)
    		   throws AccountIdFormateException, AccountIdException;
       
}
