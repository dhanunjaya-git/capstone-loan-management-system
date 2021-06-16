package com.capstone.loan.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.loan.login.dto.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer>{
	
	Mono<User> findUserByEmailAndPassword(String email, String password);

}
