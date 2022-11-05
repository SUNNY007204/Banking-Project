package com.aws.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.aws.entity.Account;
import com.aws.entity.Customer;
import com.aws.entity.RegisterCustomerDTO;
import com.aws.repository.AccountRepository;
import com.aws.repository.CustomerRepository;

@Service
public class CustomerWebService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	AccountWebService accountService;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}

	public Customer findById(int id) {
		return customerRepo.findById(id).get();
	}
	public Customer findByUsername(String username) {
		return customerRepo.findByUsername(username);
	}
	
	public Customer registerCustomer(RegisterCustomerDTO customerDTO) {
		
		Account account = new Account();
		Customer customer = new Customer();
		
		account.setHolderName(customerDTO.getName());
		account.setBalance(0);  //Inintal Balance of Customer
		account.setPassword( new BCryptPasswordEncoder().encode(customerDTO.getPassword()));
		account = accountRepo.save(account);
		
		customer.setName(customerDTO.getName());
		customer.setUsername(customerDTO.getUsername());
		customer.setPhNo(customerDTO.getPhNo());
		customer.setAddress(customerDTO.getAddress());
		customer.setAadharNo(customerDTO.getAadharNo());
		customer.setPanNo(customerDTO.getPanNo());
		customer.setAccounts(new ArrayList<>(Arrays.asList(account)));
		return customerRepo.save(customer);
	}
	
	public Customer findByAccountNo(String accountNo) {
		int accNo = accountService.getCustomerFk(accountNo);
		Customer customer =  customerRepo.findById(accNo).get();
		return customer;
	}

}
