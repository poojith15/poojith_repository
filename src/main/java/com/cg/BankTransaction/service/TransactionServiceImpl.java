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


public class TransactionServiceImpl implements TransactionService{
	TransactionDao txDao=new TransactionDaoImpl();
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
			return true;}
		
		else  {
			doCredit(accid,amt);
			return true;}
		
		 
	}
	public void doCredit(String accid,double amt) throws AccountIdException {
		AccountManagement account = txDao.getAccount(accid);
		double amount=account.getAccountBalance()+amt;
		account.setAccountBalance(amount);
		txDao.updateAccount(accid, amount);
		AccTransaction tx = new AccTransaction(accid, "CREDIT",amt, LocalDate.now());	
		account.getTrxns().add(tx);
		
	}
	public void doDebit(String accid,double amt) throws AccountIdException {
		AccountManagement account = txDao.getAccount(accid);
		double amount=account.getAccountBalance()-amt;
		account.setAccountBalance(amount);
		txDao.updateAccount(accid, amount);
		AccTransaction tx = new AccTransaction(accid, "DEBIT",amt, LocalDate.now());	
		account.getTrxns().add(tx);
	}
	
	@Override
	public List<AccTransaction> viewTransactions(String accid)
			throws AccountIdFormateException, AccountIdException {
		if(!accid.matches("[1-9][0-9]{11}")) {
			throw new AccountIdFormateException();
		}
		return txDao.getAccount(accid).getTrxns();
		
	}
	@Override
	
	public boolean doTransaction(String txType, double amt, Cheque cheque) 
			throws AccountIdFormateException, TransactionTypeException, AmountException, AccountIdException {
		
		
		if(!cheque.getChequeAccountNo().matches("[1-9][0-9]{11}")) {
			throw new AccountIdFormateException();
		}
		else if(txType.equals("Credit")||txType.equals("Debit")) {
			throw new TransactionTypeException();
		}	
		else if(txDao.getAccount(cheque.getChequeAccountNo()).getAccountBalance()<amt) {
			throw new AmountException();
		}
		if(txType.equals("Credit")) {
			doCredit(cheque.getChequeAccountNo(),amt);
			return true;}
		else  {
			doDebit(cheque.getChequeAccountNo(),amt);
			return true;}
	}
	
	
	


}
