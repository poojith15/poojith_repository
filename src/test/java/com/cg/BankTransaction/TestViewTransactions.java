package com.cg.BankTransaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cg.BankTransaction.exceptions.AccountIdException;
import com.cg.BankTransaction.exceptions.AccountIdFormateException;
import com.cg.BankTransaction.exceptions.AmountException;
import com.cg.BankTransaction.exceptions.TransactionTypeException;
import com.cg.BankTransaction.service.TransactionService;
import com.cg.BankTransaction.service.TransactionServiceImpl;

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
