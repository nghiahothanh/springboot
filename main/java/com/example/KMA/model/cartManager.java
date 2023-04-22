package com.example.KMA.model;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class cartManager {

	public static final String SESSION_KEY_SHOPPING_CART = "shoppingcart";

	public cart getCart(HttpSession session) {
		cart Cart = (cart) session.getAttribute(SESSION_KEY_SHOPPING_CART);
		if (Cart == null) {
			Cart = new cart();
		setCart(session, Cart);
		}
		return Cart;
	}

	public void setCart(HttpSession session, cart Cart) {
		session.setAttribute(SESSION_KEY_SHOPPING_CART, Cart);
	}

	// ham xoa gio hang
	public void removeCart(HttpSession session) {
		session.removeAttribute(SESSION_KEY_SHOPPING_CART);
	}
}
