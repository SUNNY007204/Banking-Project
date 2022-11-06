package com.aws.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCustomerDTO {

	String name;

	String username;
	
	String address;

	long phNo;

	long aadharNo;

	String panNo;
	
	String password;
	
	
	
}
