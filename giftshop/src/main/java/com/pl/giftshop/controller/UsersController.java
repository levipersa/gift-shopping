package com.pl.giftshop.controller;

import com.pl.giftshop.model.ProductCategory;
import com.pl.giftshop.model.Users;
import com.pl.giftshop.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/all-user")
    public ResponseEntity<List<Users>> getUsers() {

        return ResponseEntity.ok(usersRepository.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUsers(@PathVariable Long id) {
        return ResponseEntity.of(usersRepository.findById(id));
    }

    @PostMapping("/create-user")
    public ResponseEntity<Users> createProductCategory(@RequestBody Users users) {

        usersRepository.save(users);
        return ResponseEntity.ok(users);
    }

}
