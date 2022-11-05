package com.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aws.entity.Account;
import com.aws.service.AccountWebService;

@RestController
public class AccountController {
	
	@Autowired
	AccountWebService accountService;

	@GetMapping("/getAcc")
	public List<Account> getAccs() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/getacc/{id}")
	public Account getAcc(@PathVariable("id") String id) {
		return accountService.getAccount(id);
	}
}
