package com.lpu.MavenDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lpu.MavenDemo.exceptions.AccountIdException;
import com.lpu.MavenDemo.exceptions.AccountIdFormateException;
import com.lpu.MavenDemo.exceptions.AmountException;
import com.lpu.MavenDemo.exceptions.TransactionTypeException;
import com.lpu.MavenDemo.service.TransactionService;
import com.lpu.MavenDemo.service.TransactionServiceImpl;

public class TestViewTransactions {
	TransactionService ser=new TransactionServiceImpl();
	
	@DisplayName("Vadilation for account ID")
	@Test
	public void Tes1() throws AccountIdFormateException{
		assertThrows(AccountIdFormateException.class,()->ser.viewTransactions("61616"));        
    }
	@DisplayName("Funtionality of getting transactions")
	@Test
	public void Tes2() throws AccountIdFormateException, AccountIdException{
		assertEquals(1,ser.viewTransactions("100000123456"));        
    }
	@DisplayName("Funtionality of getting trxns after trxn is performed")
	@Test
	public void Tes3() throws AccountIdFormateException, AccountIdException, AmountException, TransactionTypeException{
		ser.doTransaction("100000123456", "Credit",50.0 );
		assertEquals(2,ser.viewTransactions("100000123456"));        
    }
	

}
