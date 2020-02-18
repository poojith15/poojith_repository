package com.cg.BankTransaction;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cg.BankTransaction.exceptions.AccountIdException;
import com.cg.BankTransaction.exceptions.AccountIdFormateException;
import com.cg.BankTransaction.exceptions.AmountException;
import com.cg.BankTransaction.exceptions.TransactionTypeException;
import com.cg.BankTransaction.service.TransactionService;
import com.cg.BankTransaction.service.TransactionServiceImpl;


public class TestTransactionBySlip {
	TransactionService ser=new TransactionServiceImpl();
	@DisplayName("Validation for the account ID")
	@Test
	public void Tes1() throws AccountIdFormateException{
		assertThrows(AccountIdFormateException.class,()->ser.doTransaction("516526","Debit", 50.0));        
    }
	
	@DisplayName("Validaton for the transaction type")
	@Test
	public void Test2() throws TransactionTypeException{
		assertThrows(TransactionTypeException.class,()->ser.doTransaction("100000989565","Debitt", 50.0));
	}
	
	@DisplayName("Validaton for the amount")
	@Test
	public void Test3() throws AmountException{
		assertThrows(AmountException.class,()->ser.doTransaction("100000989565","Debit", 495058382.0));
	}
	
	@DisplayName("Funtionality for debiting the amount by slip")
	@Test
	public void Test4() throws AccountIdFormateException, AmountException, TransactionTypeException, AccountIdException {
		assertTrue(ser.doTransaction("100000989565","Debit", 50.0));	
	}
	
	@DisplayName("Funtionality for crediting the amount by slip")
	@Test
	public void Test5() throws AccountIdFormateException, AmountException, TransactionTypeException, AccountIdException {
		assertTrue(ser.doTransaction("100000989565","Credit", 50.0));
		
	}
	
}