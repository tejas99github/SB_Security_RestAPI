package com.tejas.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

	@GetMapping("/home")
	public String getMeg() {
		String msg = "Welcome to SBI Bank !";
		return msg;
	}

	
	@GetMapping("/balance")
	public String getBalance() {
		String msg = "Your balance is : 3000 INR !";
		return msg;
	}

	@GetMapping("/statement")
	public String getStatement() {
		String msg = "Your statement is generated and send to your mail !";
		return msg;
	}

	@GetMapping("/myloan")
	public String getMyLoan() {
		String msg = "Your Loan Amount Due : 5,00,000 INR !";
		return msg;
	}

	@GetMapping("/contact")
	public String getContact() {
		String msg = "Thank you for contacting customer support !";
		return msg;
	}
}
