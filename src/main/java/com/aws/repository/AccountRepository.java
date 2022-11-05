package com.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aws.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
	@Query(value = "select customer_fk from account where account_no = ?1", nativeQuery = true)
	public int getCustomerId(String accountNo);
}
