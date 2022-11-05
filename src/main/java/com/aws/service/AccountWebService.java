package com.aws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.entity.Account;
import com.aws.repository.AccountRepository;

@Service
public class AccountWebService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public Account getAccount(String accountNo) {
		return accountRepository.findById(accountNo).get();
	}

	public List<Account> getAllAccounts(){
		return  accountRepository.findAll();
	}
	
	public int getCustomerFk(String accountNo) {
		return accountRepository.getCustomerId(accountNo);
	}
}
