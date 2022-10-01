package com.titanblaze.tollsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.titanblaze.tollsystem.dto.VehicleUserDto;
import com.titanblaze.tollsystem.model.JwtRequest;
import com.titanblaze.tollsystem.model.JwtResponse;
import com.titanblaze.tollsystem.model.TollRecipt;
import com.titanblaze.tollsystem.service.TollBoothService;
import com.titanblaze.tollsystem.service.UserService;
import com.titanblaze.tollsystem.utility.JwtUtility;

@RestController
public class TollChargeController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtility jwtUtility;
	
	@Autowired
	UserService userService;
	
	@Autowired
	TollBoothService tollBoothService;
	
	@PostMapping("/tollcharge")
	public TollRecipt chargeTollAmount(@RequestBody VehicleUserDto user) {
		return tollBoothService.chargeTollAmount(user);
	}
	
	
	@PostMapping("/authenticate")
	public JwtResponse authenticationUser(@RequestBody JwtRequest request) throws Exception {
		try{authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
				);
			}
		catch (BadCredentialsException e) {
			throw new Exception(e.getMessage());
		}
		final UserDetails user = userService.loadUserByUsername(request.getUserName());
		String token = jwtUtility.generateToken(user);
		return new JwtResponse(token);
	}
	
}
