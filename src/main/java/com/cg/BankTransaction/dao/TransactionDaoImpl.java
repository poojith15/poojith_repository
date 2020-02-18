package com.cg.BankTransaction.dao;

import com.cg.BankTransaction.entity.AccountManagement;
import com.cg.BankTransaction.exceptions.AccountIdException;
import com.cg.BankTransaction.repository.CgRepository;

public class TransactionDaoImpl implements TransactionDao{

	@Override
	public AccountManagement getAccount(String accountid) throws AccountIdException {
		if(!CgRepository.accList.containsKey(accountid)) 
			throw new AccountIdException();
		else
			
		return CgRepository.accList.get(accountid);
	}

	@Override
	public  void updateAccount(String accid,double amount) {
		AccountManagement acc= CgRepository.accList.get(accid);
		acc.setAccountBalance(amount);
		
	}

	
        
}
