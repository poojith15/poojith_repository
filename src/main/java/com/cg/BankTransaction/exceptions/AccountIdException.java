package com.cg.BankTransaction.exceptions;

/**
 * 
 * @author pooji
 *This is an exception class for account ID.
 */
public class AccountIdException extends Exception{

	@Override
	public String toString() {
		return "Account ID doesnot exsist";
	}
	

}
