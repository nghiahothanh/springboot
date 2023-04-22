package com.example.KMA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.KMA.model.Product;
import com.example.KMA.model.cart;
import com.example.KMA.service.ProductService;

@Controller
public class paginationController {
	   @Autowired
	    private ProductService productService;
	 @RequestMapping(value = "/products", method = RequestMethod.GET)
	    public ModelAndView getProducts(@RequestParam(name = "page", defaultValue = "1") int page) {

	        List<Product> products = productService.getProducts(page);
	   
	        long totalItems = productService.getTotalProducts();
	        int size = (int) (totalItems/4);
	        ModelAndView modelAndView = new ModelAndView("pagination.html");
	        modelAndView.addObject("products", products);
	        modelAndView.addObject("currentPage", page);
	        modelAndView.addObject("totalPages", size);
	        return modelAndView;
	    }
}
