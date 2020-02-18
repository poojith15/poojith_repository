package com.cg.BankTransaction.exceptions;
/**
 * 
 * @author pooji
 *This is an exception class for account ID format. 
 */
public class AccountIdFormateException extends Exception{

	@Override
	public String toString() {
		
		return "Entered Account ID should contain atleast 12 numbers";
	}
	

}
