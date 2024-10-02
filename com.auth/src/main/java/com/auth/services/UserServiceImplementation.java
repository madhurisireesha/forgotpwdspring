package com.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.auth.entities.User;
import com.auth.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository repo;

	@Override
	public boolean usernameExists(String username) {
		// TODO Auto-generated method stub
		User user=repo.findByUsername(username);
		if(user!=null) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		if(usernameExists(username))
		{
			//password==dbpassword
			User user=repo.findByUsername(username);
			String dbpass=user.getPassword();
			if(dbpass.equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub	
		return repo.findByEmail(email);
	}

	@Override
	public void updatePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		user.setPassword(newPassword);
		repo.save(user);
		
	}


}
