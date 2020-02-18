package com.lpu.MavenDemo.dao;

import com.lpu.MavenDemo.entity.AccountManagement;
import com.lpu.MavenDemo.exceptions.AccountIdException;
import com.lpu.MavenDemo.repository.CgRepository;

/**
 * 
 * @author poojith
 *This DAO class contains methods to access account and update account after the transaction.
 */

public class TransactionDaoImpl implements TransactionDao{
    /**
     * This method loads the account management object from the map
     * which is in the repository. 
     * 
     * @param accountid
     * 
     * @return It returns the account management instance and throws exception if it doesn't exist.
     * 
     * @throws Throws exception if account doesn't exist.
     * 
     */
	@Override
	public AccountManagement getAccount(String accountid) throws AccountIdException {
		if(!CgRepository.accList.containsKey(accountid)) 
			throw new AccountIdException();
		else
			
		return CgRepository.accList.get(accountid);
	}
	
	/**
	 * This method updates the account details into the existing account which already exists in 
	 * the repository.
	 * 
	 * @param accid
	 * @param amount
	 * 
	 * @return It does not return anything.
	 * 
	 */

	@Override
	public  void updateAccount(String accid,double amount) {
		AccountManagement acc= CgRepository.accList.get(accid);
		acc.setAccountBalance(amount);
		
	}

	
        
}
