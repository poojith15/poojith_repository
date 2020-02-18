package com.cg.BankTransaction.exceptions;
/**
 * 
 * @author poojith
 *This is an exception class for type of transaction.
 */
public class TransactionTypeException extends Exception {

	@Override
	public String toString() {
	
		return "To is not valid";
	}
     
}
