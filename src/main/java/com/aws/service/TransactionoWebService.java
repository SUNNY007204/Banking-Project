package com.aws.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.configuration.AppCustomer;
import com.aws.entity.Customer;
import com.aws.entity.Transaction;
import com.aws.exceptions.InsufficientBalanceException;
import com.aws.repository.CustomerRepository;
import com.aws.repository.TransactionRepository;

@Service
public class TransactionoWebService {
	
	@Autowired
	CustomerWebService customerService;
	
	@Autowired
	TransactionRepository transactionRepo;
	
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}
	
	public void transferMoney(int beneficiaryId, AppCustomer senderDTO, float amount) throws InsufficientBalanceException {
		Customer sender = customerService.findByUsername(senderDTO.getUsername());
		Customer reciever = customerService.findById(beneficiaryId);
		
		float balance = sender.getAccounts().get(0).getBalance();
		float beneficiaryBalance = reciever.getAccounts().get(0).getBalance();

		if (balance < amount) {
			throw new InsufficientBalanceException("Insufficient Account Balnace");
		} else {
			sender.getAccounts().get(0).setBalance(balance-amount);
			reciever.getAccounts().get(0).setBalance(beneficiaryBalance+amount);		
		}
		
		// Generate Transaction reciepts here

		
		Transaction senderReciept = new Transaction();
		senderReciept.setAmount(amount);
		senderReciept.setDate(LocalDate.now());
		senderReciept.setReciever(reciever.getAccounts().get(0).getAccountNo());
		senderReciept.setSender(sender.getAccounts().get(0).getAccountNo());
		senderReciept.setType("DEBIT");
		senderReciept = saveTransaction(senderReciept);
		
		
		Transaction recieverReciept = new Transaction();
		recieverReciept.setAmount(amount);
		recieverReciept.setDate(LocalDate.now());
		recieverReciept.setReciever(reciever.getAccounts().get(0).getAccountNo());
		recieverReciept.setSender(sender.getAccounts().get(0).getAccountNo());
		recieverReciept.setType("CREDIT");
		recieverReciept = saveTransaction(recieverReciept);


		
		  List<Transaction> senderTransactions = sender.getTransactions();  //get
		  senderTransactions.add(senderReciept);							//update
		  sender.setTransactions(senderTransactions);						//set
		  customerService.saveCustomer(sender);								//SAVE IN REPO
		  
		  List<Transaction> recieverTransactions = reciever.getTransactions();
		  recieverTransactions.add(recieverReciept);
		  reciever.setTransactions(recieverTransactions);
		  customerService.saveCustomer(reciever);		 

		System.out.println("Recievr reciept " + recieverReciept);
		System.out.println("Sender reciept " + senderReciept);
	}

}
