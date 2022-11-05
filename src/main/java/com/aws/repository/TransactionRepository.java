package com.aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aws.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
