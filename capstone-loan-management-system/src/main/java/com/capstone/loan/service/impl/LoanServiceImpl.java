package com.capstone.loan.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capstone.loan.entity.Loan;
import com.capstone.loan.login.dto.User;
import com.capstone.loan.repo.LoanRepository;
import com.capstone.loan.repo.UserRepository;
import com.capstone.loan.service.LoanService;

import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService {

	
	@Autowired
	UserRepository repository;
	
	@Autowired
	private LoanRepository loanRepository;

	
	
	@Override
	public Mono<Object> applyLoan(Loan loan) {
		Mono<User> customer = repository.findById(loan.getAccountno());
		return customer.flatMap(customerDetails -> {
			 loan.setDate(new Date(System.currentTimeMillis()));
			return loanRepository.save(loan).map(savedLoanDetils -> ResponseEntity.ok(savedLoanDetils.getLoanid()));
		});
	}

	@Override
	public Mono<Loan> viewLoanDetails(Integer loanid) {
		return loanRepository.findById(loanid);
	}	
}

