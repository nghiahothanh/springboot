package com.example.KMA.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
@EnableWebMvc
public class configResource implements WebMvcConfigurer{


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry register) {
		register.addResourceHandler("/resources/static/**");
		
		
	}
	@Autowired
	DataSource dataSource;
	
}
