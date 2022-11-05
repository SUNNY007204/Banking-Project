package com.aws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aws.configuration.AppCustomer;
import com.aws.configuration.LoggedInCustomer;
import com.aws.entity.Customer;
import com.aws.entity.RegisterCustomerDTO;
import com.aws.repository.CustomerRepository;
import com.aws.service.CustomerWebService;

@Controller
public class CustomerWebController {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Autowired
	CustomerWebService custoemrService;
	
	
	@GetMapping("/register")
	public String adduser(Model model) {
		RegisterCustomerDTO customer = new RegisterCustomerDTO();
		model.addAttribute("customer", customer);
		return "register";
	}
	
	@PostMapping("/registerCustomer")
	public String registerCustomer(@ModelAttribute("customer") RegisterCustomerDTO customerDTO, Model model) {
		Customer c = customerRepo.findByUsername(customerDTO.getUsername());
		if(c!=null) {
			String errorMessage = "User " + c.getUsername() + " already Exists";
			model.addAttribute("userExistsError", errorMessage);
			return "register";
		}
		
		custoemrService.registerCustomer(customerDTO);
		return "redirect:index";
	}

	
	@GetMapping("/index")
	public String index(Model model, @LoggedInCustomer AppCustomer customer) {
		model.addAttribute("username", customer.getUsername());
		return "index";
	}
	
}
