package com.lpu.MavenDemo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lpu.MavenDemo.exceptions.AccountIdException;
import com.lpu.MavenDemo.exceptions.AccountIdFormateException;
import com.lpu.MavenDemo.exceptions.AmountException;
import com.lpu.MavenDemo.exceptions.TransactionTypeException;
import com.lpu.MavenDemo.service.TransactionService;
import com.lpu.MavenDemo.service.TransactionServiceImpl;


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