package com.aws.entity;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLOYEE_ID")
	int employeeId;
	
	@Column(name = "EMPLOYEE_NAME")
	String empName;
	
	@Column(name = "EMPLOYEE_ADDRESS")
	String empAddress;
	
	@Column(name = "EMPLOYEE_PHONE_NO")
	String empPhNo;
	
	@Column(name = "EMPLOYEE_AADHAR_NO")
	String empAadharNo;
	
	@Column(name = "EMPLOYEE_PAN_NO")
	String empPanNo;

}
