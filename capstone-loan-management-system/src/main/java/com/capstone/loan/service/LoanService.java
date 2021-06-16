package com.capstone.loan.service;

import com.capstone.loan.entity.Loan;

import reactor.core.publisher.Mono;

public interface LoanService {

	Mono<Object> applyLoan(Loan loan);
	
	Mono<Loan> viewLoanDetails(Integer loanid);
}
