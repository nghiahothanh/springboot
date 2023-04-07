package com.example.KMA.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.KMA.service.UserDetailsServiceImpl;
@Configuration

@EnableWebSecurity
public class security {

	  
	  

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
		.authorizeHttpRequests((requests) -> requests
			 .antMatchers("/vendor/**","/css/**","/js/**","/fonts/**","/images/**","/logoutSuccessful","/").permitAll()
			 .antMatchers("/home").hasAuthority("ROLE_USER")
             .antMatchers("/admin").hasAuthority("ROLE_ADMIN")
             .anyRequest().authenticated()
			
		)
        
        .formLogin(form->
        form.loginPage("/login").permitAll()
        .loginProcessingUrl("/j_spring_security_check") 
        .failureUrl("/?=fail")
        .defaultSuccessUrl("/?login=true")
       
        )
        .logout()
        .logoutUrl("/logout") // đường dẫn URL cho chức năng logout
        .logoutSuccessUrl("/logoutSuccessful") // đường dẫn URL mà người dùng được chuyển đến sau khi đăng xuất thành công
        .invalidateHttpSession(true) // vô hiệu hóa phiên đăng nhập của người dùng
        .deleteCookies("JSESSIONID"); // xóa cookie của phiên đăng nhập
       ;
return http.build();
    }
	  
  
    	
    	@Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
    
			
    	@Autowired
    	private UserDetailsServiceImpl userDetailsService;

	    
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication()
//	            .withUser("user").password("{noop}password").roles("USER")
//	            .and()
//	            .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	    	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
 
	    }
	    
	  
}
