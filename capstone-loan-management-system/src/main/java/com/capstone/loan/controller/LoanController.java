package com.capstone.loan.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.loan.entity.Customer;
import com.capstone.loan.entity.Loan;
import com.capstone.loan.service.LoanService;

import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	PasswordEncoder encoder;	
	
	
	//TO DO need to implement login logic
	@PostMapping("/customer/login")
	public Mono<Customer> loginCustomer(@RequestBody Customer customer)
			throws URISyntaxException {
		customer.setPassword(encoder.encode(customer.getPassword()));
		return loanService.loginUser(customer);
	}
	
	@GetMapping("/loanDetails")
	public Mono<Loan> viewLoanDetails(Integer loanId){
		return loanService.viewLoanDetails(loanId);
	}
	
	
	@PostMapping("/applyLoan")
	public Mono<Loan> applyLoan(@RequestBody Loan loan)
			throws URISyntaxException {
		return loanService.applyLoan(loan);
	}
}
