package com.capstone.loan.service;

import com.capstone.loan.login.dto.User;

import reactor.core.publisher.Mono;

public interface UserService {
	
	Mono<User> loginUser(String email, String password);


}
