package com.alexyom.dojos.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.alexyom.dojos.models.User;
import com.alexyom.dojos.repositories.UserRepository;
@Component
public class UserValidator implements Validator{
	private static final String email_regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	
	@Autowired
	private UserRepository uRepo;
	
	public UserValidator() {
		this.pattern = Pattern.compile(email_regex);
	}
	
	public boolean EmailValidator(String email) {
		this.matcher = this.pattern.matcher(email);
		return matcher.matches();
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
        
        if(this.uRepo.existsByEmail(user.getEmail())) {
    		errors.rejectValue("email","unique","Email has already been used");
    	}
	}
}
