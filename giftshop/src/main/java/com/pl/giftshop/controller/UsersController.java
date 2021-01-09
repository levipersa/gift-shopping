package com.pl.giftshop.controller;

import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.model.Users;
import com.pl.giftshop.repository.UsersRepository;
import com.pl.giftshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsers(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }


    @PostMapping("/create-user")
    public ResponseEntity<Users> createUser(@RequestBody Users users) {

        Users users1 = new Users();
        users1.setUserName(users.getUserName());
        users1.setPassword(encoder().encode(users.getPassword()));
        userService.create(users1);
        return ResponseEntity.ok(users1);
    }

    @Bean
    private PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
