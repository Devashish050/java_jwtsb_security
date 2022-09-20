package com.javajwt.java_jwtsb_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javajwt.java_jwtsb_security.service.CustomUserDetailsService;
import com.javajwt.java_jwtsb_security.model.jwtRequest;
import com.javajwt.java_jwtsb_security.model.jwtResponse;
import com.javajwt.java_jwtsb_security.utill.jwtUtill;

@RestController
public class jwtcontroller {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetails;

	@Autowired
	jwtUtill jwtutill;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody jwtRequest jwtRequest) throws Exception{

		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));  
		} catch (UsernameNotFoundException | BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails = this.customUserDetails.loadUserByUsername(jwtRequest.getUsername());

		String token=this.jwtutill.generateToken(userDetails);
		
		System.out.println("jwt:"+token);
		
		return ResponseEntity.ok(new jwtResponse(token));
	}
}
