package com.springproject.ClothingEcommerce.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.ClothingEcommerce.model.User;
import com.springproject.ClothingEcommerce.repository.UserRepository;
import com.springproject.ClothingEcommerce.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void signup(User user) {
		userRepo.save(user);		
	}

	@Override
	public User login(String un, String psw) {		
		return userRepo.findByUnameAndPassword(un, psw);
	}

	@Override
	public User ifExist(String un) {		
		return userRepo.findByUname(un);
	}
}
