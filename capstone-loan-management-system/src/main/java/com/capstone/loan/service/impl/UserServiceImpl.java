package com.capstone.loan.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.loan.login.dto.User;
import com.capstone.loan.repo.UserRepository;
import com.capstone.loan.service.UserService;

import reactor.core.publisher.Mono;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public Mono<User>  loginUser(String email, String password) {
		Mono<User> user = userRepository.findUserByEmailAndPassword(email, password);
		
		if (user != null) {
			return user.flatMap(userlogedin->{
				userlogedin.setLoggedIn(true);
				return userRepository.save(userlogedin);
				
			});
		
	}
		else {
			return user.flatMap(userloginfailure->{
				userloginfailure.setLoggedIn(false);
				return userRepository.save(userloginfailure);
			});
		}
	}
	}


