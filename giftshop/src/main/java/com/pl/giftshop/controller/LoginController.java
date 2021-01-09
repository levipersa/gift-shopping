package com.pl.giftshop.controller;

import com.pl.giftshop.model.Users;
import com.pl.giftshop.security.DatabaseUsersDetailsService;
import com.pl.giftshop.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private DatabaseUsersDetailsService databaseUsersDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/login")
    public ResponseEntity<String> login(@RequestBody Users users) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword()));

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid credentials!");
        }

        UserDetails userDetails = databaseUsersDetailsService.loadUserByUsername(users.getUserName());

        return ResponseEntity.ok("{ \"token\": \"" + jwtProvider.createToken(userDetails.getUsername()) + "\" }");

    }

}
