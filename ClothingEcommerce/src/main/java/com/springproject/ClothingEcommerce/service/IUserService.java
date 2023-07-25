package com.springproject.ClothingEcommerce.service;

import com.springproject.ClothingEcommerce.model.User;

public interface IUserService {
	
	void signup(User user);
	
	User login(String un, String psw);
	
	User ifExist(String un);	
	
}
