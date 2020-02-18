package com.lpu.MavenDemo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lpu.MavenDemo.entity.Cheque;
import com.lpu.MavenDemo.exceptions.AccountIdException;
import com.lpu.MavenDemo.exceptions.AccountIdFormateException;
import com.lpu.MavenDemo.exceptions.AmountException;
import com.lpu.MavenDemo.exceptions.TransactionTypeException;
import com.lpu.MavenDemo.service.TransactionService;
import com.lpu.MavenDemo.service.TransactionServiceImpl;

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
