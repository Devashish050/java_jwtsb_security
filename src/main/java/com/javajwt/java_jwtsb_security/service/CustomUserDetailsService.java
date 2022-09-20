package com.javajwt.java_jwtsb_security.service;

import java.util.ArrayList;

import com.javajwt.java_jwtsb_security.model.User;
import com.javajwt.java_jwtsb_security.model.customUserDetails;
import com.javajwt.java_jwtsb_security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        final User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        } else {
            return new customUserDetails(user);
        }

        //static
//		if (username.equals("Dev1")) {
//
//			return new User("Dev1", "Dev123", new ArrayList<>());
//
//		} else {
//
//			throw new UsernameNotFoundException("User not found");
//
//		}
    }

}
