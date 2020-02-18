package com.cg.BankTransaction.exceptions;
/**
 * 
 * @author poojith
 *This is an exception class for amount in account.
 */
public class AmountException extends Exception{

	@Override
	public String toString() {
		return "Entered amount is not present in the given Account";
	}
    
}
