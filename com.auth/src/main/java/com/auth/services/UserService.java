package com.auth.services;

import org.springframework.stereotype.Controller;

import com.auth.entities.User;

public interface UserService {
	boolean usernameExists(String username);
	void addUser(User user);
	boolean validateUser(String username,String password);
	User findByEmail(String email);
	void updatePassword(User user, String newPassword);
	
}
