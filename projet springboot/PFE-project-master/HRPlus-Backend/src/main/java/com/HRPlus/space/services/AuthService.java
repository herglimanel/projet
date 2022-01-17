package com.HRPlus.space.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HRPlus.space.dto.RegisterRequest;
import com.HRPlus.space.entities.UserInformation;
import com.HRPlus.space.repositories.IUtilidateurRepo;

@Service
public class AuthService {
	@Autowired
	private IUtilidateurRepo userRepo ; 
	
	public void signup (RegisterRequest registerRequest) {
		UserInformation user = new UserInformation();
		user.setNom(registerRequest.getUserName());
		user.setPassword(registerRequest.getPassword());
		user.setEmail(registerRequest.getEmail());
		userRepo.save(user);
	}
	
}
