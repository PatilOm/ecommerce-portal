package com.omkar.pro.dao;

import java.util.List;

import com.omkar.pro.dto.Address;
import com.omkar.pro.dto.User;

//public interface UserDAO {
//	
//	//add an user
//		boolean addUser(User user);
//		User getByEmail(String email);
//		
//		//add an address
//		boolean addAddress(Address address);
//		Address getBillingAddress(User user);
//		List<Address> listShippingAddress(User user);
//		//alternative so that less queries get generated
//		//Address getBillingAddress(int userId);
//		//List<Address> listShippingAddress(int userId);
//		
//		
//}

public interface UserDAO {

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean addUser(User user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}




