package com.aws.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aws.entity.Account;
import com.aws.entity.Customer;
import com.aws.entity.RegisterCustomerDTO;
import com.aws.repository.AccountRepository;
import com.aws.repository.CustomerRepository;

@RestController
public class CustomerController {
	
	@Autowired
	AccountRepository accountRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	@GetMapping("/getAll")
	public List<Customer> getCusts(){
		return custRepo.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Customer getCust(@PathVariable("id") int id) {
		System.out.println(id);
		Customer cust = custRepo.findById(id).get();
		System.out.println("Customer caught");
		for(Account a : cust.getAccounts()) {
			System.out.println("In for loop");
			System.out.println(a);
		}
		return cust;
	}
	
	
	@PostMapping("/registerCustomerr")
	public Customer save(@RequestBody RegisterCustomerDTO customerDTO) {
		
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
		
		return custRepo.save(customer);
	}
}
