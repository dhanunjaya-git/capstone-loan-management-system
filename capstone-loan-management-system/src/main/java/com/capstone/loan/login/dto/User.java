package com.capstone.loan.login.dto;

import java.util.Collection;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UserDetails;

public class User {

	@NotNull 
	private String username;
	@NotNull
    private String password;
    private Collection<String> roles;
    private boolean loggedIn;


    public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public UserDetails toUserDetails() {
    	return new MyUserDetails();
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<String> getRoles() {
		return roles;
	}

	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}
}
