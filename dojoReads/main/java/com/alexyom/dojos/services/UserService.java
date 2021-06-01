package com.alexyom.dojos.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexyom.dojos.models.User;
import com.alexyom.dojos.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
		
	//Register User and Hash their Password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
	
	//Authenticate User
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		} else {
			
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
				}
			
			else {
				return false;
				}
		}
	}
	
	//Find User By id
	public User findUserById(Long id) {
		Optional<User> u = uRepo.findById(id);
		
		if(u.isPresent()) {
			return u.get();
			
		} else {
			return null;
		}
	}
	
	//Find User By email
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	//Find All Users
	public List<User> findAll() {
		return (List<User>) uRepo.findAll();
	}

}
