package com.aws;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.aws.entity.Account;
import com.aws.entity.Customer;
import com.aws.repository.AccountRepository;
import com.aws.repository.CustomerRepository;

@SpringBootTest
class BankManagementApplicationTests {

	@Autowired
	AccountRepository accRepo;

	@Autowired
	CustomerRepository custRepo;
}
