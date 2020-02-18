package com.cg.BankTransaction.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.BankTransaction.dao.TransactionDao;
import com.cg.BankTransaction.dao.TransactionDaoImpl;
import com.cg.BankTransaction.entity.AccountManagement;
import com.cg.BankTransaction.entity.Cheque;
import com.cg.BankTransaction.entity.AccTransaction;
import com.cg.BankTransaction.exceptions.AccountIdException;
import com.cg.BankTransaction.exceptions.AccountIdFormateException;
import com.cg.BankTransaction.exceptions.AmountException;
import com.cg.BankTransaction.exceptions.TransactionTypeException;

/**
 * 
 * @author poojith
 *This class contains the methods of debit and credit transaction by slip and cheque. 
 */
public class TransactionServiceImpl implements TransactionService{
	TransactionDao txDao=new TransactionDaoImpl();
	/**
	 * This method validates the received input.After they are properly validated, transaction will be 
	 * completed (debit or credit).  
	 * 
	 * @param accid
	 * @param txType
	 * @param amt
	 * 
	 * @return This returns the boolean value after the transaction is completed.
	 * 
	 * @throws It throws AccountIdFormateException, TransactionTypeException, AccountIdException and AmountException.
	 */
	@Override
	public boolean doTransaction(String accid, String txType, double amt) 
			throws AmountException, AccountIdFormateException, TransactionTypeException, AccountIdException{
		
		if(!accid.matches("[1-9][0-9]{11}")) {
			throw new AccountIdFormateException();
		}
		else if(!(txType.equals("Credit")||txType.equals("Debit"))) {
			throw new TransactionTypeException();
		}	
		
		if(txType.equals("Debit")) {
			   if(txDao.getAccount(accid).getAccountBalance()<amt) {
					throw new AmountException();
			   }
			   doDebit(accid,amt);
			   return true;
		}
		
		else  {
			doCredit(accid,amt);
			return true;
		}	 
	}
	
	/**
	 * This method does the crediting amount in to account. 
	 * 
	 * @param accid
	 * @param amt
	 * 
	 * @return void
	 * 
	 * @throws AccountIdException
	 */
	public void doCredit(String accid,double amt) throws AccountIdException {
		AccountManagement account = txDao.getAccount(accid);
		double amount=account.getAccountBalance()+amt;
		account.setAccountBalance(amount);
		txDao.updateAccount(accid, amount);
		AccTransaction tx = new AccTransaction(accid, "CREDIT",amt, LocalDate.now());	
		account.getTrxns().add(tx);
		
	}
	
	/**
	 * This method does the debiting amount in to account.
	 *  
	 * @param accid
	 * @param amt
	 * 
	 * @return void
	 * 
	 * @throws AccountIdException
	 */
	public void doDebit(String accid,double amt) throws AccountIdException {
		AccountManagement account = txDao.getAccount(accid);
		double amount=account.getAccountBalance()-amt;
		account.setAccountBalance(amount);
		txDao.updateAccount(accid, amount);
		AccTransaction tx = new AccTransaction(accid, "DEBIT",amt, LocalDate.now());	
		account.getTrxns().add(tx);
	}
	
	/**
	 * This method loads the transactions in a particular account in to a list.
	 * 
	 * @param accid
	 * 
	 * @return List of transactions
	 * 
	 * @throws AccountIdFormateException and AccountIdException
	 */
    @Override 
	public int viewTransactions(String accid)
			throws AccountIdFormateException, AccountIdException {
		if(!accid.matches("[1-9][0-9]{11}")) {
			throw new AccountIdFormateException();
		}
		return txDao.getAccount(accid).getTrxns().size();
		
	}
    
    /**
     * This method validates the received input.After they are properly validated, transaction will be 
	 * completed (debit or credit).
	 * 
	 *  @param txType
	 *  @param amt
	 *  @param cheque (Cheque instance)
	 *  
	 *  @return boolean 
	 *  
	 *  @throws AccountIdFormateException, TransactionTypeException, AmountException and AccountIdException
     */
	@Override
	public boolean doTransaction(Cheque cheque,String txType, double amt) 
			throws AccountIdFormateException, TransactionTypeException, AmountException, AccountIdException {
		
		
		if(!cheque.getChequeAccountNo().matches("[1-9][0-9]{11}")) {
			throw new AccountIdFormateException();
		}
		else if(!(txType.equals("Credit")||txType.equals("Debit"))) {
			throw new TransactionTypeException();
		}	
		
		if(txType.equals("Debit")) {
		    if(txDao.getAccount(cheque.getChequeAccountNo()).getAccountBalance()<amt) {
				throw new AmountException();
			}
			doCredit(cheque.getChequeAccountNo(),amt);
			return true;
		}
		else  {
			doDebit(cheque.getChequeAccountNo(),amt);
			return true;
		}
	}
	
	
	


}
