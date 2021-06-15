package com.capstone.loan.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.capstone.loan.entity.Customer;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<Customer, Integer>{
	
	Mono<Customer> findByUsernameAndPassword(String username, String password);

}
