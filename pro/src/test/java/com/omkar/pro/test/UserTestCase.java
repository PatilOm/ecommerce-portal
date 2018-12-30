package com.omkar.pro.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.omkar.pro.dao.UserDAO;
import com.omkar.pro.dto.Address;
import com.omkar.pro.dto.Cart;
import com.omkar.pro.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.omkar.pro");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Omkar");
		user.setLastName("Patil");
		user.setEmail("op@gmail.com");
		user.setContactNumber("9876543210");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("Vastu Vinayak");
		address.setAddressLineTwo("Lodha Heritage");
		address.setCity("Dombivli");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("421201");
		address.setBilling(true);
		
		// link the user with the address using user id
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart = new Cart();
			cart.setUserId(user.getId());
			
			//add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("Emrald");
			address.setAddressLineTwo("Palava");
			address.setCity("Dombivli");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("421204");
			address.setShipping(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		}
	}
}
