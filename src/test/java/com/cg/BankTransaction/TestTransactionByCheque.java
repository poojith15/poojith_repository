package com.cg.BankTransaction;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cg.BankTransaction.entity.Cheque;
import com.cg.BankTransaction.exceptions.AccountIdException;
import com.cg.BankTransaction.exceptions.AccountIdFormateException;
import com.cg.BankTransaction.exceptions.AmountException;
import com.cg.BankTransaction.exceptions.TransactionTypeException;
import com.cg.BankTransaction.service.TransactionService;
import com.cg.BankTransaction.service.TransactionServiceImpl;

public class TestTransactionByCheque {
	TransactionService ser=new TransactionServiceImpl();
	@DisplayName("Validaton for the account ID")
	@Test
	public void Test1() throws AccountIdFormateException{
		Cheque cheque=new Cheque("61613",LocalDate.now());
		assertThrows(AccountIdFormateException.class,()->ser.doTransaction(cheque,"Debit", 50.0));
	}
	//
	@DisplayName("Validaton for the transaction type")
	@Test
	public void Test2() throws TransactionTypeException{
		Cheque cheque=new Cheque("100000989565",LocalDate.now());
		assertThrows(TransactionTypeException.class,()->ser.doTransaction(cheque,"Debitt", 50.0));
	}
	
	@DisplayName("Validaton for the amount")
	@Test
	public void Test3() throws AmountException{
		Cheque cheque=new Cheque("100000989565",LocalDate.now());
		assertThrows(AmountException.class,()->ser.doTransaction(cheque,"Debit", 495058382.0));
	}
	
	@DisplayName("Funtionality for debiting the amount by cheque")
	@Test
	public void Test4() throws AccountIdFormateException, AmountException, TransactionTypeException, AccountIdException {
		Cheque cheque=new Cheque("100000989565",LocalDate.now());
		assertTrue(ser.doTransaction(cheque,"Debit", 50.0));	
	}
	
	@DisplayName("Funtionality for crediting the amount by cheque")
	@Test
	public void Test5() throws AccountIdFormateException, AmountException, TransactionTypeException, AccountIdException {
		Cheque cheque=new Cheque("100000989565",LocalDate.now());
		assertTrue(ser.doTransaction(cheque,"Credit", 50.0));
		
	}
}
