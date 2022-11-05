package com.aws.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aws.configuration.AppCustomer;
import com.aws.configuration.LoggedInCustomer;
import com.aws.entity.Customer;
import com.aws.entity.Transaction;
import com.aws.exceptions.InsufficientBalanceException;
import com.aws.service.CustomerWebService;
import com.aws.service.TransactionoWebService;

@Controller
public class TransactionController {

	@Autowired
	TransactionoWebService transactionService;

	@Autowired
	CustomerWebService customerService;

	@GetMapping("/transfer")
	public String transferMoney(Model model) {
		return "transfer";
	}

	@GetMapping("/transferByAccountNo")
	public String searchByUsername(@RequestParam("accountNo") String accountNo, Model model) throws Exception {
		try {
			Customer customer = customerService.findByAccountNo(accountNo);
			model.addAttribute("customers", new ArrayList<>(Arrays.asList(customer)));
			return "transfer";

		} catch (Exception e) {
			model.addAttribute("accountNoNotFound", "Account not found");
		}
		return "transfer";

	}

	@GetMapping("/transfer/{id}")
	public String transfer(@PathVariable("id") int beneficiaryId, Model model) {
		Customer beneficiaryCustomer = customerService.findById(beneficiaryId);
		model.addAttribute("beneficiaryId", beneficiaryId);
		model.addAttribute("Beneficiary_Name", beneficiaryCustomer.getName());
		model.addAttribute("Beneficiary_PhNo", beneficiaryCustomer.getPhNo());
		model.addAttribute("Beneficiary_AccNo", beneficiaryCustomer.getAccounts().get(0).getAccountNo());
		return "transaction";
	}

	@PostMapping("/transfer/{id}")
	public String transferMoney(@LoggedInCustomer AppCustomer loggedInCustomer, @PathVariable("id") int id,
			@RequestParam("transferAmount") float amount, Model model, RedirectAttributes redirectAttribute) {
		String status = "";
		try {
			transactionService.transferMoney(id, loggedInCustomer, amount);
			status = "Transaction Succesful, You can view your transactions on My Transactions Page";
		} catch (InsufficientBalanceException e) {
			status = "Transaction Unsuccesful, Insufficient Balance";
		}

		redirectAttribute.addFlashAttribute("status", status);
		return "redirect:/index";
	}

	@GetMapping("/history")
	public String history(@LoggedInCustomer AppCustomer loggedInCustomer, Model model) {

		Customer currentCustoemr = customerService.findByUsername(loggedInCustomer.getUsername());
		List<Transaction> myTransactions = currentCustoemr.getTransactions();
		
		model.addAttribute("transactions", myTransactions);
		return "history";
	}

}
