package com.capstone.loan.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.capstone.loan.entity.Loan;

public interface LoanRepository extends ReactiveCrudRepository<Loan, Integer>{

}
