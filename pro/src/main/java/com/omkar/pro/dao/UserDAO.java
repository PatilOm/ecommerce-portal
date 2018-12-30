package com.omkar.pro.dao;

import com.omkar.pro.dto.Address;
import com.omkar.pro.dto.Cart;
import com.omkar.pro.dto.User;

public interface UserDAO {
	
	//add an user
		boolean addUser(User user);
		
		//add an address
		boolean addAddress(Address address);
		
		//add a cart
		boolean addCart(Cart cart);
}




