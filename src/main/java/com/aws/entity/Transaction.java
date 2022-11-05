package com.aws.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_ID")
	int transactionId;
	
	@Column(name = "AMOUNT")
	float amount;
	
	@Column(name = "SENDER_ACC_NO")
	String sender;
	
	@Column(name = "RECIEVER_ACC_NO")
	String reciever;
	
	@Column(name = "TRANSACTION_DATE")
	LocalDate date;
	
	@Column(name = "TRANSACTION_TYPE")
	String type;  //SENT, RECIEVED, WITHDRAWED


}
