package com.omkar.pro.dao;

import com.omkar.pro.dto.Address;
import com.omkar.pro.dto.Cart;
import com.omkar.pro.dto.User;

public interface UserDAO {
	
	//add an user
		boolean addUser(User user);
		User getByEmail(String email);
		
		//add an address
		boolean addAddress(Address address);
		
		//update a cart
		boolean updateCart(Cart cart);
}




