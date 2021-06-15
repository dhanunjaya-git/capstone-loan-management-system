package com.capstone.loan.service;

import com.capstone.loan.entity.Customer;
import com.capstone.loan.entity.Loan;

import reactor.core.publisher.Mono;

public interface LoanService {

	Mono<Customer> loginUser(Customer customer);

	Mono<Loan> applyLoan(Loan loan);
	
	Mono<Loan> viewLoanDetails(Integer loanid);
}
