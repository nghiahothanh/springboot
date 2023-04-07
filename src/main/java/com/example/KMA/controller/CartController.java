package com.example.KMA.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.KMA.mapper.ProductMapper;
import com.example.KMA.model.Product;
import com.example.KMA.model.cart;
import com.example.KMA.model.cartManager;
import com.example.KMA.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	cartManager CartManager;
	@Autowired 
	ProductMapper productMapper;
	@Autowired
	ProductService service;
	@RequestMapping("/add")
	public String add(Model model,
			HttpSession session,
			 @RequestParam("id") int id,
			@RequestParam(value = "qty" , required = false , defaultValue ="1" ) int qty)
	{
		
		Product product = service.get(id);
		cart Cart= CartManager.getCart(session);
		Cart.addItem(product, qty);
		model.addAttribute("cart", Cart);
		return "cart.html";
		
	}
	  @RequestMapping("/update")
	    public String update(Model model, HttpServletRequest request,
	    		HttpSession session, @RequestParam("id") int id, @RequestParam("qty") int qty){
		  String firstName = request.getParameter("id");
		  int num = Integer.parseInt(firstName);
		  System.out.println(num);
		  session.setAttribute("exampleData", "This is an example");
		  Product product = service.get(num);
	    	cart Cart  = CartManager.getCart(session);
	//    	Cart.addItem(product, qty);
	        Cart.updateItem(product, qty);
	        model.addAttribute("cart", Cart);
	        return "cart.html";
	    }

	    @RequestMapping("/remove")
	    public String remove(HttpSession session, 
	    		Model model,@RequestParam("id") int id){
	    	Product product = service.get(id);
	    	cart Cart = CartManager.getCart(session);
	        Cart.removeItem(product);
	        model.addAttribute("cart", Cart);
	        return "cart";
	    }
}
