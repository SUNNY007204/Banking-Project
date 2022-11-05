package com.aws.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	int customerId;

	@Column(name = "HOLDER_NAME")
	String name;

	@Column(name = "USERNAME")
	String username;
	
	@Column(name = "ADDRESS")
	String address;

	@Column(name = "PHONE_NO")
	long phNo;

	@Column(name = "AADHAR_NO")
	long aadharNo;

	@Column(name = "PAN_NO")
	String panNo;
	
	
	@OneToMany(targetEntity = Account.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="CUSTOMER_FK",referencedColumnName = "CUSTOMER_ID")
	List<Account> accounts;
	
	
	  @OneToMany(targetEntity = Transaction.class,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name ="CUSTOMER_FK",referencedColumnName = "CUSTOMER_ID")
	  List<Transaction> transactions;
	 
	
	public Customer() {
		
	}
	
}
