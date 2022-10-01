package com.titanblaze.tollsystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.titanblaze.tollsystem.model.TollUser;
import com.titanblaze.tollsystem.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TollUser user = userRepository.getUserDetailByUserNameAndPassword(username);
		return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
