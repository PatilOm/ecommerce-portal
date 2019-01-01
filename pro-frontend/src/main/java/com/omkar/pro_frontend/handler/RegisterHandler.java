package com.omkar.pro_frontend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.omkar.pro.dao.UserDAO;
import com.omkar.pro.dto.Address;
import com.omkar.pro.dto.Cart;
import com.omkar.pro.dto.User;
import com.omkar.pro_frontend.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		//checking if password matches confirm password
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not match the confirm password!").build());
			
			transitionValue = "failure";
		}
		//check the uniqueness of the email id
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is already used!").build());
			transitionValue = "failure";
		}
		return transitionValue;
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		//fetch user
		User user = model.getUser();
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//save the user
		userDAO.addUser(user);
		
		//get address
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
}