package com.example.KMA.controller;

import java.net.http.HttpRequest;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.KMA.mapper.ProductMapper;
import com.example.KMA.mapper.UserMapper;
import com.example.KMA.model.Product;
import com.example.KMA.model.ProductExample;
import com.example.KMA.model.User;
import com.example.KMA.model.UserExample;








@Controller
public class homeController {

	@Autowired
	UserMapper userMapper;
	@Autowired
	ProductMapper productMapper;
	@RequestMapping("/")
	public ModelAndView Index(Product product , Model model) {


		ModelAndView modelandview = new ModelAndView("index");
		
		UserExample example = new UserExample();
		ProductExample productExample =new ProductExample();
		
		 
		List<Product>listProducts = productMapper.selectByExample(productExample);
		
		model.addAttribute("product", listProducts);
		List<User> listUsers = userMapper.selectByExample(example);
		for (User user : listUsers) {
			System.out.println(user.getFull_name());
		}
		return modelandview;
	}   

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "register";
	}
	@PostMapping("/process_register")
	public String processRegister(User user) {
 

		BCryptPasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(user.getUser_password());
		user.setUser_password(encodePassword);
	    userMapper.insertSelective(user);
	          
	      
	      
	    return "register_success";
	}
	@RequestMapping(value = "/home")
	
	public ModelAndView modelAndView() {

		ModelAndView modelAndView2 = new ModelAndView("home");

		return modelAndView2;
	}
	
	@RequestMapping(value = "/admin")
	
	public ModelAndView modelAndView1(Principal principal) {

		ModelAndView modelAndView2 = new ModelAndView("admin");
		String usernameString= principal.getName();
	
		System.out.println(usernameString);
		return modelAndView2; 
	}
	  @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	    public String logoutSuccessfulPage(Model model) {
	        model.addAttribute("title", "Logout");
	        return "logoutSuccessfulPage";
	    }

	  @RequestMapping("/cart")
	    public String cart(){
	        return "cart";
	    }

}
