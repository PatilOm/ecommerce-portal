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
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Omkar");
//		user.setLastName("Patil");
//		user.setEmail("op@gmail.com");
//		user.setContactNumber("9876543210");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		//add the user
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("Vastu Vinayak");
//		address.setAddressLineTwo("Lodha Heritage");
//		address.setCity("Dombivli");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("421201");
//		address.setBilling(true);
//		
//		// link the user with the address using user id
//		address.setUserId(user.getId());
//		
//		//add the address
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			//create a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			//add the cart
//			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//			
//			//add a shipping address for this user
//			address = new Address();
//			address.setAddressLineOne("Emrald");
//			address.setAddressLineTwo("Palava");
//			address.setCity("Dombivli");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("421204");
//			address.setShipping(true);
//			
//			//link it with the user
//			address.setUserId(user.getId());
//			
//			//add the shipping address
//			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//		}
//	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Omkar");
//		user.setLastName("Patil");
//		user.setEmail("op@gmail.com");
//		user.setContactNumber("9876543210");
//		user.setRole("USER");
//		user.setPassword("123456");
//				
//		if(user.getRole().equals("USER")) {
//			//create a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			//attach cart with the user
//			user.setCart(cart);
//
//		}
//		//add the user
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//	}
	
//	@Test
//	public void testUpdateCart() {
//		//fetch the user by its email
//		user = userDAO.getByEmail("op@gmail.com");
//		
//		//get the cart of the user
//		cart = user.getCart();
//		
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
//	}
	
//	@Test
//	public void testAddAddress() {
//		//we need to add an user
//		user = new User();
//		user.setFirstName("Omkar");
//		user.setLastName("Patil");
//		user.setEmail("op@gmail.com");
//		user.setContactNumber("9876543210");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		//add the user
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		//add address
//		address = new Address();
//		address.setAddressLineOne("Vastu Vinayak");
//		address.setAddressLineTwo("Lodha Heritage");
//		address.setCity("Dombivli");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("421201");
//		address.setBilling(true);
//		
//		//attach user to address
//		address.setUser(user);
//		assertEquals("Failed to add adddress!", true, userDAO.addAddress(address));
//		
//		//add shipping address
//		address = new Address();
//		address.setAddressLineOne("Emrald");
//		address.setAddressLineTwo("Palava");
//		address.setCity("Dombivli");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("421204");
//		address.setShipping(true);
//		
//		//attach user to address
//		address.setUser(user);
//		assertEquals("Failed to add shipping adddress!", true, userDAO.addAddress(address));
//	}
	
//	@Test 
//	public void testAddAddress() {
//		user = userDAO.getByEmail("op@gmail.com");
//		//add shipping address
//		address = new Address();
//		address.setAddressLineOne("Green Emrald");
//		address.setAddressLineTwo("Lodha Heven");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400021");
//		address.setShipping(true);
//		
//		//attach user to address
//		address.setUser(user);
//		assertEquals("Failed to add shipping adddress!", true, userDAO.addAddress(address));
//	}
	
//	@Test
//	public void testGetAddresses() {
//		user = userDAO.getByEmail("op@gmail.com");
//		
//		assertEquals("Failed to fetch list of addresses and size doesnot match!", 2, userDAO.listShippingAddress(user).size());
//		
//		assertEquals("Failed to fetch billing address and size doesnot match!", "Dombivli", userDAO.getBillingAddress(user).getCity());
//	}
}
