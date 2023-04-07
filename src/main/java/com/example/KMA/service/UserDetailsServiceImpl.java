package com.example.KMA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.KMA.mapper.UserMapper;
import com.example.KMA.model.User;
import com.example.KMA.model.UserExample;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserMapper userMapper; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(username);

		List<User> listUsers = userMapper.selectByExample(example);

		if (listUsers.size() > 0) {
			User user = listUsers.get(0);
			  List<GrantedAuthority> authorities = new ArrayList<>();
			  authorities.add(new SimpleGrantedAuthority(user.getRole()));
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUser_name(),
					user.getUser_password(), authorities);
			return userDetails;
		}
		 
		else {
			new UsernameNotFoundException("login fail");
		}
		return null;
	}


}
