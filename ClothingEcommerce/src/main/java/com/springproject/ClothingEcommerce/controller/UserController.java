package com.springproject.ClothingEcommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springproject.ClothingEcommerce.model.User;
import com.springproject.ClothingEcommerce.service.IUserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User  usr = userService.login(user.getUname(), user.getPassword());		
			
		if(usr != null) {
				session.setAttribute("validUser", usr);
				session.setMaxInactiveInterval(200);
				
				return "home";
				
			}else {		
				model.addAttribute("Message","User not Found!!!");
				return  "login";
			}
	}
	
	@GetMapping("/signup")
	public String getSignin() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String postSignin(@ModelAttribute User user, Model model) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.signup(user);
		model.addAttribute("message","Signed-up successfully");
		return "login";
	}
	
}
