package com.example.KMA.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.KMA.mapper.ProductMapper;
import com.example.KMA.model.Product;
import com.example.KMA.model.cart;
import com.example.KMA.model.cartItem;
import com.example.KMA.model.cartManager;
import com.example.KMA.service.ProductService;
import com.mysql.cj.Session;

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
	    		HttpSession session, @RequestParam("id") int id, @RequestParam("qti") int qty){
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
	    @RequestMapping("/listcart")
	    public String liSt(HttpSession session, Model model) {
	    	cart Cart = CartManager.getCart(session);
	    	model.addAttribute("cart", Cart);
	    	return "cart.html";
	    }
	  
	    @RequestMapping("/insert")
	    public String insert(Model model) {
	    	Product product = new Product();
	    	model.addAttribute("product", product);
	    	
	    	return "add-product";
	    	
	    }
	    @PostMapping("/save-product")
	    public String saveProduct( Product product , @RequestParam("imageFile") MultipartFile imageFile,BindingResult result) throws IOException {
	    	  if (result.hasErrors()) {
	    	        return "product-form";
	    	    }
	    	service.save(product,imageFile);
	        return "redirect:/";
	    }
	    @PostMapping("/checkout")
	    public String checkout(@RequestParam(value = "productIds" ) List<String> productIdStrings,
	    		 @RequestParam(value = "productPrice0") double productPrice0,
                 @RequestParam(value = "productPrice1") double productPrice1) {
	        // Convert productIdStrings to List<Integer> using Integer.parseInt()
	        List<Integer> productIds = new ArrayList<>();
	        List<Integer> IntQty = new ArrayList<>();
	        for (String productIdString : productIdStrings) {
	            productIds.add(Integer.parseInt(productIdString));
	        }
	        cart Cart = new cart();
	    	
	    	
	       for (Integer integer : productIds) {
			Product product = service.get(integer);	
			int quantity= product.getPrice();
			
			Cart.addItem(product,quantity);
			
		}
	        int total = (int) Cart.getTotal();
	        
	        return "index";
	    }

	    
}
