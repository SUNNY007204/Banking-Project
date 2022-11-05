package com.aws.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aws.entity.Customer;
import com.aws.repository.AccountRepository;
import com.aws.repository.CustomerRepository;

@Service
public class CustomerAuthService implements UserDetailsService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer customerInDatabase = customerRepository.findByUsername(username);
		
		if(customerInDatabase == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		return new AppCustomer(customerInDatabase);
	}

	
	
}
