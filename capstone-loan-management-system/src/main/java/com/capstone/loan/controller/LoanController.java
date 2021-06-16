package com.capstone.loan.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.loan.entity.Customer;
import com.capstone.loan.entity.Loan;
import com.capstone.loan.login.dto.User;
import com.capstone.loan.service.LoanService;
import com.capstone.loan.service.UserService;

import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	PasswordEncoder encoder;	
	
	
	@PostMapping("/login")
	public Mono<User> loginCustomer(@RequestParam("email") String email ,@RequestParam("password") String password){ 
//		User user = new User();
//		user.setPassword(encoder.encode(password));
		return userservice.loginUser(email,password);
	}
	
	@GetMapping("/loanDetails")
	public Mono<Loan> viewLoanDetails(Integer loanId){
		return loanService.viewLoanDetails(loanId);
	}
	
	
	@PostMapping("/applyLoan")
	public Mono<Loan> applyLoan(@RequestBody Loan loan) {
		return loanService.applyLoan(loan);
	}
}
