package com.omkar.pro_frontend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omkar.pro.dao.CartLineDAO;
import com.omkar.pro.dto.Cart;
import com.omkar.pro.dto.CartLine;
import com.omkar.pro_frontend.model.UserModel;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//returns cart of the user who has logged in
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns entire cartLine
	public List<CartLine> getCartLines(){
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}
}
